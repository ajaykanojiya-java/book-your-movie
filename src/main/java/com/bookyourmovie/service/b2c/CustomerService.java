package com.bookyourmovie.service.b2c;

import com.bookyourmovie.domain.entities.User;

public interface CustomerService {

    public User registerUser(User user);
    public User deleteUser(User user);
    public User updateUser(User user);
    public User fetchUser(User user);
}
