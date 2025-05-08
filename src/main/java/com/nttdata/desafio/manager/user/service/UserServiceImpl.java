package com.nttdata.desafio.manager.user.service;

import com.nttdata.desafio.manager.user.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public User create(User userRequest) {
        return null;
    }

    @Override
    public User update(User updateUserRequest) {
        return null;
    }

    @Override
    public List<User> list() {
        return List.of();
    }

    @Override
    public User get() {
        return null;
    }

    @Override
    public void delete() {

    }
}
