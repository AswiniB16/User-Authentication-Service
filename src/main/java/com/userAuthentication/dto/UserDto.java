package com.userAuthentication.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private Long id;
    private String UserName;
    private String email;
    private String password;
    public String securityQuestionAnswer;
}
