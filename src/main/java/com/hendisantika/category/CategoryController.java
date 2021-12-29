package com.hendisantika.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
 * Time: 17.12
 */
@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String listCategories(Model model) {
        List<Category> listCategories = categoryRepository.findAll();
        model.addAttribute("listCategories", listCategories);
        return "categories";
    }

    @GetMapping("/new")
    public String showNewCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "category_form";
    }

    @PostMapping
    public String saveCategory(Category category) {
        categoryRepository.save(category);
        return "redirect:/categories";
    }
}
