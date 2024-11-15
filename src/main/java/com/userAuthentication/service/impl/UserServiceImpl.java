package com.userAuthentication.service.impl;

import com.userAuthentication.dao.entity.User;
import com.userAuthentication.dao.repository.UserRepository;
import com.userAuthentication.dto.UserDto;
import com.userAuthentication.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
import static com.userAuthentication.util.PasswordEncryption.generateSalt;
import static com.userAuthentication.util.PasswordEncryption.hashPassword;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    public UserRepository userRepository;

    public List<UserDto> getLoggedInUser(User loggedUser) {
        var userList = new ArrayList<UserDto>();
        var users = userRepository.getByEmail(loggedUser.getEmail());
        if (!CollectionUtils.isEmpty(users)) {
            var user = users.get(0);
            String hashedEnteredPassword = hashPassword(loggedUser.getPassword(), user.getSalt());
            if (hashedEnteredPassword.equals(user.getPassword())) {
                userList.add(UserDto.builder().UserName(user.getUserName()).email(user.getEmail()).id(user.getId()).build());
            }
        }
        return userList;
    }

    @Override
    public User save(UserDto user) {
        var users = userRepository.getByEmail(user.getEmail());
        if (CollectionUtils.isEmpty(users)) {
            String salt = generateSalt();
            String hashedPassword = hashPassword(user.getPassword(), salt);

            var userDetails = User.builder()
                    .userName(user.getUserName())
                    .email(user.getEmail())
                    .password(hashedPassword)
                    .salt(salt).securityQuestionAnswer(user.securityQuestionAnswer).build();
            return userRepository.save(userDetails);
        }
        return User.builder().build();
    }


}
