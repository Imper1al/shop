package com.website.shop.validators;

import com.website.shop.entity.User;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class UserValidator {

    public boolean validateUserData(User user) {
        return StringUtils.isNotEmpty(user.getEmail()) &&
                StringUtils.isNotEmpty(user.getPhoneNumber()) &&
                StringUtils.isNotEmpty(user.getPassword());
    }
}
