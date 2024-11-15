package com.userAuthentication.dto;

import lombok.Data;

@Data
public class PasswordResetValidationRequest {

    private String email;
    private String securityQuestionAnswer;
    private String password;
}
