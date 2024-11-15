package com.userAuthentication.controller;

import com.userAuthentication.dao.entity.User;
import com.userAuthentication.dto.PasswordResetValidationRequest;
import com.userAuthentication.service.PasswordRecoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/bookexchangeplatform")
public class PasswordRecoveryController {

    @Autowired
    PasswordRecoveryService passwordRecoveryService;

    @PostMapping(value = "/validate-request")
    public List<User> validateResetRequest(@RequestBody PasswordResetValidationRequest validationRequest){
        return passwordRecoveryService.validateResetRequest(validationRequest);
    }

    @PostMapping(value = "/reset-password")
    public void resetPasswordRequest(@RequestBody PasswordResetValidationRequest validationRequest){
        passwordRecoveryService.resetPasswordRequest(validationRequest);
    }
}
