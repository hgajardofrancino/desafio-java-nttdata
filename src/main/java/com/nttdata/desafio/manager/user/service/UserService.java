package com.nttdata.desafio.manager.user.service;

import com.nttdata.desafio.manager.user.model.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User update(User user);
    List<User> list();
    User get();
    void delete();
}
