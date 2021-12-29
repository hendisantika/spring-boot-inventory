package com.hendisantika.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-inventory
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/12/21
 * Time: 16.56
 */
@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/new")
    public String showNewProductForm(Model model) {
        List<Category> listCategories = categoryRepository.findAll();

        model.addAttribute("product", new Product());
        model.addAttribute("listCategories", listCategories);

        return "product_form";
    }

    @PostMapping
    public String saveProduct(Product product, HttpServletRequest request) {
        String[] detailsIDs = request.getParameterValues("detailsID");
        String[] detailsNames = request.getParameterValues("detailsName");
        String[] detailsValues = request.getParameterValues("detailsValue");

        for (int i = 0; i < detailsNames.length; i++) {
            if (detailsIDs != null && detailsIDs.length > 0) {
                product.setDetails(Integer.valueOf(detailsIDs[i]), detailsNames[i], detailsValues[i]);
            } else {
                product.addDetails(detailsNames[i], detailsValues[i]);
            }
        }

        productRepository.save(product);
        return "redirect:/";
    }

    @GetMapping
    public String listProducts(Model model) {
        List<Product> listProducts = productRepository.findAll();
        model.addAttribute("listProducts", listProducts);

        return "products";
    }

}
