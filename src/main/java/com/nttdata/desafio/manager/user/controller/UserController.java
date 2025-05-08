package com.nttdata.desafio.manager.user.controller;

import com.nttdata.desafio.manager.user.controller.request.UserRequest;
import com.nttdata.desafio.manager.user.controller.response.UserResponse;
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

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody UserRequest request) {

        try {

            return ResponseEntity.ok(null);

        } catch (Exception e) {

            return ResponseEntity.badRequest()
                    .body(null);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<UserResponse>> listAll() {


        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(
            @PathVariable String id,
            @RequestBody UserRequest request) {

        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> get(
            @PathVariable String id
    ){
        return ResponseEntity.ok(null);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable String id) {

        boolean wasDeleted = true;

        if (!wasDeleted) {
            return ResponseEntity
                    .notFound()
                    .build();
        }

        return ResponseEntity
                .noContent()
                .build();
    }

}
