package com.website.shop.mappers;

import com.website.shop.rest.UserRequest;

public interface Mapper<F, T> {

    T mapTo(F from);

    F createUserRequestToUser(UserRequest userRequest);
}
