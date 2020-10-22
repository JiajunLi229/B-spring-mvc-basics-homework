package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<Number, User> userMap = new HashMap<>();

    public UserService() {
        userMap.put(1, new User("123@qq.com", "user", "password"));
    }

    public void register (User user) {
        if(userMap.containsValue(user)){
            throw new ExistedUserException("用户已存在");
        }
        Number userId = userMap.size() + 1;
        userMap.put(userId, user);
    }
}
