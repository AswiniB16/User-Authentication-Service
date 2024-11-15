package com.userAuthentication.dao.repository;

import com.userAuthentication.dao.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasswordRecoveryRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users u WHERE LOWER(u.email) = LOWER(?1) and u.security_question_answer =?2", nativeQuery = true)
    List<User> getByEmail(String email,String securityAnswer);

    @Query(value = "SELECT * FROM users u WHERE LOWER(u.email) = LOWER(?1)", nativeQuery = true)
    List<User> getByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "UPDATE users SET salt = ?1,password = ?2 WHERE LOWER(email) = LOWER(?3)",nativeQuery = true)
    int resetPassword(String salt, String hashedPassword, String email);
}
