package com.thoughtworks.capacity.gtb.mvc;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody @Valid User user) {
        userService.register(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public User loginUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        return userService.loginUser(username, password);
    }
}
