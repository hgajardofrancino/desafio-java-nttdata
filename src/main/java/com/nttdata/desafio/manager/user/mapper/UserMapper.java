package com.nttdata.desafio.manager.user.mapper;

import com.nttdata.desafio.manager.user.controller.request.UserRequest;
import com.nttdata.desafio.manager.user.controller.response.UserResponse;
import com.nttdata.desafio.manager.user.model.Phone;
import com.nttdata.desafio.manager.user.model.User;
import com.nttdata.desafio.manager.user.repository.entity.PhoneEntity;
import com.nttdata.desafio.manager.user.repository.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    // Mapea de UserRequest a User
    public User toUser(UserRequest req) {
        if (req == null) return null;

        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());

        if (req.getPhones() != null) {
            List<Phone> phones = req.getPhones().stream()
                    .map(p -> {
                        Phone phone = new Phone();
                        phone.setNumber(p.getNumber());
                        phone.setCityCode(p.getCityCode());
                        phone.setCountryCode(p.getCountryCode());
                        return phone;
                    }).toList();
            user.setPhones(phones);
        }

        return user;
    }

    // Mapea de User a UserEntity
    public UserEntity toUserEntity(User user) {
        if (user == null) return null;

        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setToken(user.getToken());
        entity.setActive(user.getActive());
        entity.setCreated(user.getCreated());
        entity.setModified(user.getModified());
        entity.setLastLogin(user.getLastLogin());

        if (user.getPhones() != null) {
            List<PhoneEntity> phones = user.getPhones().stream()
                    .map(p -> {
                        PhoneEntity pe = new PhoneEntity();
                        pe.setNumber(p.getNumber());
                        pe.setCityCode(p.getCityCode());
                        pe.setCountryCode(p.getCountryCode());
                        return pe;
                    }).toList();
            entity.setPhones(phones);
        }

        return entity;
    }

    // Mapea de UserEntity a User
    public User toUser(UserEntity entity) {
        if (entity == null) return null;

        User user = new User();
        user.setId(entity.getId());
        user.setName(entity.getName());
        user.setEmail(entity.getEmail());
        user.setPassword(entity.getPassword());
        user.setToken(entity.getToken());
        user.setActive(entity.getActive());
        user.setCreated(entity.getCreated());
        user.setModified(entity.getModified());
        user.setLastLogin(entity.getLastLogin());

        if (entity.getPhones() != null) {
            List<Phone> phones = entity.getPhones().stream()
                    .map(pe -> {
                        Phone p = new Phone();
                        p.setNumber(pe.getNumber());
                        p.setCityCode(pe.getCityCode());
                        p.setCountryCode(pe.getCountryCode());
                        return p;
                    }).toList();
            user.setPhones(phones);
        }

        return user;
    }

    // Mapea de User a UserResponse
    public UserResponse toUserResponse(User user) {
        if (user == null) return null;

        UserResponse resp = new UserResponse();
        resp.setId(user.getId());
        resp.setCreated(user.getCreated());
        resp.setModified(user.getModified());
        resp.setLastLogin(user.getLastLogin());
        resp.setToken(user.getToken());
        resp.setActive(user.getActive());

        return resp;
    }
}

