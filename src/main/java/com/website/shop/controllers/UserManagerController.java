package com.website.shop.controllers;

import com.website.shop.entity.User;
import com.website.shop.mappers.impl.UserMapper;
import com.website.shop.rest.UserRequest;
import com.website.shop.rest.DeleteUsersRequest;
import com.website.shop.rest.UserResponse;
import com.website.shop.services.UserService;
import com.website.shop.utils.UserControllerUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/user-manager")
public class UserManagerController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createUser(@Valid @RequestBody UserRequest userRequest) {
        User user = userMapper.createUserRequestToUser(userRequest);
        userService.createUser(user);
        URI location = UserControllerUtils.getUserLocation(user.getId());
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/update/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@Valid @RequestBody UserRequest userRequest, @PathVariable(name = "user_id") long userId) {
        User user = userMapper.createUserRequestToUser(userRequest);
        userService.updateUser(userId, user);
    }

//    @Operation(summary = "Delete users", description = "Delete users by ids", responses = {
//            @ApiResponse(responseCode = "400", description = " input validation failed", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))),
//            @ApiResponse(responseCode = "200", description = "Delete operation successful")
//    })
    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUsers(@Valid @RequestBody DeleteUsersRequest request) {
        userService.deleteUsers(request.getUserIds());
    }

    @GetMapping("/user/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUser(@PathVariable(name = "user_id") long userId) {
        User user = userService.getUser(userId);
        return userMapper.mapTo(user);
    }
}
