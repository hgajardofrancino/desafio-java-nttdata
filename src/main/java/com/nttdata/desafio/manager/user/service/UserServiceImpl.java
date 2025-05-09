package com.nttdata.desafio.manager.user.service;

import com.nttdata.desafio.manager.user.mapper.UserMapper;
import com.nttdata.desafio.manager.user.model.User;
import com.nttdata.desafio.manager.user.repository.UserRepository;
import com.nttdata.desafio.manager.user.repository.entity.PhoneEntity;
import com.nttdata.desafio.manager.user.repository.entity.UserEntity;
import com.nttdata.desafio.manager.user.validators.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper userMapper;
    private final EmailValidator emailValidator;

    @Override
    public User create(final User user) throws Exception {

        emailValidator.validate(user.getEmail());

        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new Exception("El correo ya está registrado");
        }

        UserEntity userEntity = userMapper.toUserEntity(user);

        LocalDateTime now = LocalDateTime.now();
        userEntity.setCreated(now);
        userEntity.setModified(now);
        userEntity.setLastLogin(now);
        userEntity.setActive(true);

        userEntity.setToken(generateToken());

        userEntity =  repository.save(userEntity);

        return userMapper.toUser(userEntity);
    }

    @Override
    @Transactional
    public User update(final User user) throws Exception {

        UserEntity currentEntity = repository.findById(user.getId())
                .orElseThrow(() -> new Exception("Usuario no encontrado con ID: " + user.getId()));


        currentEntity.setName(user.getName());

        if (!currentEntity.getEmail().equals(user.getEmail())) {

            emailValidator.validate(user.getEmail());

            if (repository.findByEmail(user.getEmail()).isPresent()) {
                throw new Exception("El nuevo correo ya está registrado");
            }
            currentEntity.setEmail(user.getEmail());
        }

        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            currentEntity.setPassword(user.getPassword());
        }

        if (user.getPhones() != null) {
            currentEntity.setPhones(user.getPhones().stream()
                    .map(p -> {
                        PhoneEntity pe = new PhoneEntity();
                        pe.setNumber(p.getNumber());
                        pe.setCityCode(p.getCityCode());
                        pe.setCountryCode(p.getCountryCode());
                        return pe;
                    })
                    .collect(Collectors.toList()));
        }

        currentEntity.setModified(LocalDateTime.now());

        UserEntity updatedEntity = repository.save(currentEntity);
        return userMapper.toUser(updatedEntity);

    }

    @Override
    @Transactional(readOnly = true)
    public List<User> list() {
        return repository.findAll().stream()
                .map(userMapper::toUser)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public User get(final String id) throws Exception {
        UserEntity entity = repository.findById(id)
                .orElseThrow(() -> new Exception("Usuario no encontrado con ID: " + id));
        return userMapper.toUser(entity);
    }

    @Override
    @Transactional
    public void delete(final String id) throws Exception {

        if (!repository.existsById(id)) {
            throw new Exception("Usuario no encontrado con ID: " + id);
        }

        repository.deleteById(id);
        repository.flush();

        boolean exists = repository.existsById(id);

        if (exists) {
            throw new Exception("El usuario no fue eliminado");
        }
    }

    private String generateToken() {
        return UUID.randomUUID().toString() ;
    }
}
