package com.example.demo.user;

import com.example.demo.user.api.ApiResponse;
import com.example.demo.user.api.request.CreateUserRequest;
import com.example.demo.user.api.request.UpdateUserRequest;
import com.example.demo.user.api.response.CreateUserResp;
import com.example.demo.user.api.response.DeleteUserResp;
import com.example.demo.user.api.response.UpdateUserResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createUser(@RequestBody CreateUserRequest request){
        userService.createUser(request);
        return new ResponseEntity<>(new CreateUserResp(), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody UpdateUserRequest request, @PathVariable("id") Long id){
        userService.updateUser(request, id);
        return new ResponseEntity<>(new UpdateUserResp(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(new DeleteUserResp(), HttpStatus.OK);
    }
}

