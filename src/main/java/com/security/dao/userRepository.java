package com.security.dao;

import com.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface userRepository extends JpaRepository<User,Long> {
    public List<User> queryByEmail(String email);
}
