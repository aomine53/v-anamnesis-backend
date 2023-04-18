package com.vanamnesis.doctor_service.model;

import lombok.Data;

@Data
public class JwtRequest {
    String username;
    String password;
}
