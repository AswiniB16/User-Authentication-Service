package com.userAuthentication.dao.repository;

import com.userAuthentication.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users u WHERE LOWER(u.email) = LOWER(?1)", nativeQuery = true)
    List<User> getByEmail(String email);
}
