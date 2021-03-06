package com.hendisantika.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-inventory
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/12/21
 * Time: 16.23
 */
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public String userList(Model model) {
        List<User> listUsers = userRepository.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/new")
    public String showUserRegistrationForm(Model model) {
        List<Role> listRoles = roleRepository.findAll();

        model.addAttribute("listRoles", listRoles);
        model.addAttribute("user", new User());

        return "user_form";
    }

    @PostMapping
    public String saveUser(User user) {
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String showUserEditForm(@PathVariable("id") Integer id, Model model) {
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);

        List<Role> listRoles = roleRepository.findAll();
        model.addAttribute("listRoles", listRoles);

        return "user_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
        return "redirect:/users";
    }
}
