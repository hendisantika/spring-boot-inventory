package com.hendisantika;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
public class AppController {
    @GetMapping({"", "/"})
    public String viewHomePage() {
        return "index";
    }
}
