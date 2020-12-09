package com.shoppingcart.payload.response;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.shoppingcart.models.User;
import com.shoppingcart.payload.request.UserRequest;

@Component
public class UserRequestToUser implements Converter<UserRequest, User> {

    @Override
    public User convert(UserRequest userRequest) {
        User user = new User();
        if (!StringUtils.isEmpty(userRequest.getId())) {
            user.setId(userRequest.getId());
        }
        user.setEmail(userRequest.getEmail());
        user.setUsername(userRequest.getUsername());
        return user;
    }
}
