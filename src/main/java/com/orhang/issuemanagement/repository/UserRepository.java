package com.orhang.issuemanagement.repository;

import com.orhang.issuemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
    User findByUserName(String username);
}
