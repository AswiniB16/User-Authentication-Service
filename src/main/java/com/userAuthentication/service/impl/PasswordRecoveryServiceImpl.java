package com.userAuthentication.service.impl;

import com.userAuthentication.dao.entity.User;
import com.userAuthentication.dao.repository.PasswordRecoveryRepository;
import com.userAuthentication.dto.PasswordResetValidationRequest;
import com.userAuthentication.service.PasswordRecoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static com.userAuthentication.util.PasswordEncryption.generateSalt;
import static com.userAuthentication.util.PasswordEncryption.hashPassword;

@Service
public class PasswordRecoveryServiceImpl implements PasswordRecoveryService {

    @Autowired
    PasswordRecoveryRepository passwordRecoveryRepository;

    @Override
    public List<User> validateResetRequest(PasswordResetValidationRequest validationRequest) {
        return passwordRecoveryRepository.getByEmail(validationRequest.getEmail(), validationRequest.getSecurityQuestionAnswer());
    }

    @Override
    public void resetPasswordRequest(PasswordResetValidationRequest validationRequest) {
        var user = passwordRecoveryRepository.getByEmail(validationRequest.getEmail());
        String salt = generateSalt();
        String hashedPassword = hashPassword(validationRequest.getPassword(), salt);
        passwordRecoveryRepository.resetPassword(salt, hashedPassword, validationRequest.getEmail());
    }
}
