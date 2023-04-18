import { render } from '@testing-library/react';
import React,{useState} from 'react';
import { Link, useParams, useNavigate } from "react-router-dom";
import "./PrescriptionPage.css";


function PrescriptionPage (props){
    const { id } = useParams();
    const [prescriptions, setPrescriptions] = useState([]);
    const handleInputChange = (event, index, property) => {
    const newPrescriptions = [...prescriptions];

      newPrescriptions[index][property] = event.target.type === 'checkbox' ? event.target.checked : event.target.value;
      setPrescriptions(newPrescriptions);

    }

    const handleAddRow = () => {
      setPrescriptions([...prescriptions, { name: '', morning: false, afternoon: false, evening: false, beforeMeal: true }]);

    }

    const handleRemoveRow = (index) => {
      const newPrescriptions = [...prescriptions];
        newPrescriptions.splice(index, 1);
        setPrescriptions(newPrescriptions);
    }

 

      const handleBeforeMealChange = (index) => {

      const newPrescriptions = [...prescriptions];

      newPrescriptions[index].beforeMeal = true;

      setPrescriptions(newPrescriptions);

    }

 

    const handleAfterMealChange = (index) => {

      const newPrescriptions = [...prescriptions];

      newPrescriptions[index].beforeMeal = false;

      setPrescriptions(newPrescriptions);

    }

 

    const handleSubmit = (event) => {

      event.preventDefault();

      // Here you can perform any logic to save the prescription names, such as sending them to an API or storing them in local state.

      console.log(prescriptions);

      setPrescriptions([]);

    }




    return (

        <div>


          <h3 className = "text-center">Prescription:</h3>




<form onSubmit={handleSubmit} className="prescription-form">
  {prescriptions.map((prescription, index) => (
    <div key={index} className="prescription-row">
      <label className="prescription-label">
        Medicine Name {index + 1}:
        <input
          type="text"
          value={prescription.name}
          onChange={(event) => handleInputChange(event, index, 'name')}
          className="prescription-input"
        />
      </label>
      <label className="prescription-label">
        Morning:
        <input
          type="checkbox"
          checked={prescription.morning}
          onChange={(event) => handleInputChange(event, index, 'morning')}
          className="prescription-input"
        />
      </label>
      <label className="prescription-label">
        Afternoon:
        <input
          type="checkbox"
          checked={prescription.afternoon}
          onChange={(event) => handleInputChange(event, index, 'afternoon')}
          className="prescription-input"
        />
      </label>
      <label className="prescription-label">
        Evening:
        <input
          type="checkbox"
          checked={prescription.evening}
          onChange={(event) => handleInputChange(event, index, 'evening')}
          className="prescription-input"
        />
      </label>
      <label className="prescription-label">
        Before Meal:
        <input
          type="radio"
          name={`meal-${index}`}
          value="before"
          checked={prescription.beforeMeal}
          onChange={() => handleBeforeMealChange(index)}
          className="prescription-input"
        />
      </label>
      <label className="prescription-label">
        After Meal:
        <input
          type="radio"
          name={`meal-${index}`}
          value="after"
          checked={!prescription.beforeMeal}
          onChange={() => handleAfterMealChange(index)}
          className="prescription-input"
        />
      </label>
      <button type="button" onClick={() => handleRemoveRow(index)}>Remove Prescription</button>
    </div>
  ))}
  <button type="button" onClick={handleAddRow}>Add Prescription</button>
  <button type="submit">Submit</button>
</form>


        </div>

    );

};




export default PrescriptionPage;
