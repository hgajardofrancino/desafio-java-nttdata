package com.nttdata.desafio.manager.user.controller;

import com.nttdata.desafio.manager.user.controller.request.UserRequest;
import com.nttdata.desafio.manager.user.controller.response.ErrorResponse;
import com.nttdata.desafio.manager.user.controller.response.UserResponse;
import com.nttdata.desafio.manager.user.mapper.UserMapper;
import com.nttdata.desafio.manager.user.model.User;
import com.nttdata.desafio.manager.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/")
    public ResponseEntity<?> create(
            @RequestBody UserRequest request) {

        try {

            User user = userMapper.toUser(request);

            User createdUser = userService.create(user);

            UserResponse userResponse = userMapper.toUserResponse(createdUser);

            return ResponseEntity.ok(userResponse);

        } catch (Exception e) {

            ErrorResponse error = ErrorResponse
                    .builder()
                    .message(e.getMessage())
                    .build();

            return ResponseEntity.badRequest()
                    .body(error);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<UserResponse>> listAll() {

        List<User> userList = userService.list();

        List<UserResponse> userResponseList = userList
                .stream()
                .map(userMapper::toUserResponse)
                .toList();

        return ResponseEntity.ok(userResponseList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable String id,
            @RequestBody UserRequest request) {

        try {

           User toUpdateUser =  userMapper.toUser(request);
           toUpdateUser.setId(id);

           User updatedUser = userService.update(toUpdateUser);

           var userResponse = userMapper.toUserResponse(updatedUser);

           return ResponseEntity.ok(userResponse);

        } catch (Exception e) {
            ErrorResponse error = ErrorResponse
                    .builder()
                    .message(e.getMessage())
                    .build();

            return ResponseEntity.badRequest()
                    .body(error);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(
            @PathVariable String id
    ){
        try {
            User user = userService.get(id);

            return ResponseEntity.ok(userMapper.toUserResponse(user));

        } catch (Exception e) {
            ErrorResponse error = ErrorResponse
                    .builder()
                    .message(e.getMessage())
                    .build();

            return ResponseEntity.badRequest()
                    .body(error);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(
            @PathVariable String id) {

        try {
            userService.delete(id);

            return ResponseEntity
                    .noContent()
                    .build();

        } catch (Exception e) {
            ErrorResponse error = ErrorResponse
                    .builder()
                    .message(e.getMessage())
                    .build();

            return ResponseEntity.badRequest()
                    .body(error);
        }


    }

}
