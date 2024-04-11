package com.inventory.Inventory_Management.product;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    public Product createNewProduct(Product product) {
        product.setProduct_name(product.getProduct_name().trim());
        if (product.getProduct_name().length() < 5 || product.getProduct_name().length() > 20) {
            throw new IllegalArgumentException("Product's name must be of length 5 to 20.");
        }
        return this.productRepository.insert(product);
    }

    public Product getOneProduct(Integer id) {
        return this.productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Product updateProduct(Integer id, Product product) {
        return this.productRepository.update(id, product).orElseThrow(() -> new ProductNotFoundException(id));
    }

    public void deleteProduct(Integer id) {
        this.productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        this.productRepository.deleteById(id);
    }
}
