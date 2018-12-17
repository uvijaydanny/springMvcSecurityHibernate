package com.luv2code.springsecurity.demo.initbinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryUserService implements UserService {
    private Map<Long, User> userMap = new HashMap<>();

    @Override
    public void saveUser (User user) {
        if (user.getId() == null) {
            user.setId((long) (userMap.size() + 1));
        }
        userMap.put(user.getId(), user);

    }

    @Override
    public List<User> getAllUsers () {
        return new ArrayList<>(userMap.values());
    }
}
