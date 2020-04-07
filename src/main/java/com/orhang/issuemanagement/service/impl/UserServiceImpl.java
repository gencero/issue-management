package com.orhang.issuemanagement.service.impl;

import com.orhang.issuemanagement.entity.User;
import com.orhang.issuemanagement.repository.UserRepository;
import com.orhang.issuemanagement.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if (user.getEmail() == null) {
            throw new IllegalArgumentException("Username can not be null");
        }

        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {

        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {

        return userRepository.findAll(pageable);
    }

    @Override
    public User getByUserName(String userName) {

        return userRepository.findByUserName(userName);
    }
}
