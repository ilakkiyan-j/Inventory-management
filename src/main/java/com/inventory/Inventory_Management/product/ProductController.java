package com.inventory.Inventory_Management.product;
import jakarta.validation.constraints.Null;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/main")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAllProducts(Model model) {
        List<Product> products = this.productService.getAll();
        model.addAttribute("products", products);;
        return "index";
    }

    @GetMapping("/{id}")
    public String getOne(
            Model model,
            @PathVariable("id") Integer productId
    ) {
        try {
            Product product = this.productService.getOneProduct(productId);
            model.addAttribute("product", product);
        } catch (ProductNotFoundException e) {
            model.addAttribute("error", e.getLocalizedMessage());
        }
        return "index";
    }

    @GetMapping("edit")
    public String newOrderPage(Model model, @RequestParam Map<String, String> params) {
        Product product = null;
        if (params.containsKey("id")) {
            Integer id = Integer.valueOf(params.get("id"));
            try {
                product = this.productService.getOneProduct(id);
            } catch (RuntimeException e) {
                System.out.println("Product with id = " + id + " not found.");
            }
        }
        if (product == null) {
            product = new Product();
        }
        model.addAttribute("product", product);
        return "NewProduct";
    }

    @PutMapping
    public String createOrUpdate(@ModelAttribute("product") Product product) {
        if (product.getProduct_id() != null && product.getProduct_id().intValue() <=10 ) {
            this.productService.updateProduct(product.getProduct_id(), product);

        } else {
            this.productService.createNewProduct(product);
        }
        return "redirect:/main";
    }

    @DeleteMapping("{id}")
    public String deleteProduct(@PathVariable("id") Integer productId) {
        this.productService.deleteProduct(productId);
        return "redirect:/main";
    }

    //product Find
    @GetMapping("/search")
    public String searchProduct(Model model, @RequestParam("id") Integer productId) {
        try {
            Product product = this.productService.getOneProduct(productId);
            model.addAttribute("FindProduct", product); // Change here
        } catch (ProductNotFoundException e) {
            model.addAttribute("error", e.getLocalizedMessage());
        }
        return "index";
    }

    @PostMapping("/search")
    public String searchProductPost(Model model, @RequestParam("id") Integer productId) {
        return "redirect:/main/search?id=" + productId;
    }

}
