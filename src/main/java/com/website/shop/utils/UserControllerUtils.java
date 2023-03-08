package com.website.shop.utils;

import com.website.shop.controllers.UserManagerController;
import lombok.experimental.UtilityClass;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.net.URI;

@UtilityClass
public class UserControllerUtils {

    public static URI getUserLocation(Long userId) {
        return WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(UserManagerController.class)
                        .getUser(userId)).toUri();
    }
}
