package com.thoughtworks.capacity.gtb.mvc;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<Number, User> userMap = new HashMap<>();
    private User user;

    public UserService() {
        userMap.put(1, new User(1, "123@qq.com", "user", "password"));
    }

    public void register(User user) {
        if (userMap.containsValue(user)) {
            throw new ExistedUserException("用户已存在");
        }
        int userId = userMap.size() + 1;
        userMap.put(userId, user);
        user.setId(userId);
    }

    public User loginUser(String username, String password) {

        for (User user : userMap.values()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserLoginException("用户名或者密码错误");
    }
}
