package com.luv2code.springsecurity.demo.initbinder;
import java.util.List;

public interface UserService {

    void saveUser(User user);

    List<User> getAllUsers();
}