package com.hendisantika;

import com.hendisantika.user.Role;
import com.hendisantika.user.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-inventory
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/12/21
 * Time: 17.31
 */
@Controller
@Slf4j
public class AppController {
    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void initRoles() {
        roleRepository.saveAll(
                Arrays.asList(
                        new Role(1, "ADMIN"),
                        new Role(2, "USER"),
                        new Role(3, "MARKETING")));
        log.info("Init Roles");
    }

    @GetMapping({"", "/"})
    public String viewHomePage() {
        return "index";
    }
}
