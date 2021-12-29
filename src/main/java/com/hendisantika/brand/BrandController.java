package com.hendisantika.brand;

import com.hendisantika.category.Category;
import com.hendisantika.category.CategoryRepository;
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
 * Time: 17.18
 */
@Controller
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/new")
    public String showCreateNewBrandForm(Model model) {
        List<Category> listCategories = categoryRepository.findAll();

        model.addAttribute("listCategories", listCategories);
        model.addAttribute("brand", new Brand());
        return "brand_form";
    }

    @PostMapping
    public String saveBrand(Brand brand) {
        brandRepository.save(brand);
        return "redirect:/";
    }

    @GetMapping
    public String listBrand(Model model) {
        List<Brand> listBrands = brandRepository.findAll();
        model.addAttribute("listBrands", listBrands);

        return "brand";
    }

    @GetMapping("/edit/{id}")
    public String showModifyMarkForm(@PathVariable("id") Integer id, Model model) {
        List<Category> listCategories = categoryRepository.findAll();
        Brand brand = brandRepository.findById(id).get();

        model.addAttribute("listCategories", listCategories);
        model.addAttribute("brand", brand);
        return "brand_form";
    }
}
