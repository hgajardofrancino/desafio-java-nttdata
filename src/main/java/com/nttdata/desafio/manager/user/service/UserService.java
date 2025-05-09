package com.nttdata.desafio.manager.user.service;

import com.nttdata.desafio.manager.user.model.User;

import java.util.List;

public interface UserService {
    User create(final User user) throws Exception;
    User update(final User user) throws Exception;
    List<User> list();
    User get(final String id) throws Exception;
    void delete(final String id) throws Exception;
}
