package com.vanammesis.patientservice.constants;

public class Constants {

    public static final String[] PUBLIC_URLS = {"api-patients/signUp","/api-patients/login",
            "api-patients/signUp/all"
    };


    public static final long JWT_TOKEN_VALIDITY = 5l * 60 * 60;

    public static final String STATUS = "status";

    public static final String MESSAGE = "message";

    public static final String SUCCESS = "success";

    public static final String SECRET_KEY = "secret";

}