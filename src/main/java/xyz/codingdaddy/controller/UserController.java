package xyz.codingdaddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import xyz.codingdaddy.domain.User;
import xyz.codingdaddy.repository.UserRepository;

/**
 * {@link User} controller
 *
 * @author serhiy
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/list";
    }

    @GetMapping(value = "/user/{id}")
    public String getUser(Model model, @PathVariable Long id) {
        userRepository.findById(id).ifPresent(u -> model.addAttribute("user", u));
        return "user/view";
    }

    @GetMapping(value = "/user")
    public String newUser() {
        return "user/new";
    }

    @PostMapping(value = "/user")
    public String newUser(Model model, User user) {
        model.addAttribute("user", userRepository.save(user));
        return "user/view";
    }
}