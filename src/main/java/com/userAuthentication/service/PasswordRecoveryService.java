package com.userAuthentication.service;

import com.userAuthentication.dao.entity.User;
import com.userAuthentication.dto.PasswordResetValidationRequest;

import java.util.List;

public interface PasswordRecoveryService {

    List<User> validateResetRequest(PasswordResetValidationRequest validationRequest);

    void resetPasswordRequest(PasswordResetValidationRequest validationRequest);
}
