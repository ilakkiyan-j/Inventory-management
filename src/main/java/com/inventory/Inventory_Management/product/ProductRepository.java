package com.inventory.Inventory_Management.product;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository {

    private final JdbcClient jdbcClient;

    public ProductRepository(JdbcTemplate template, JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Product> findAll() {
        return jdbcClient.sql("SELECT * FROM product")
                .query((rs, rowNum) -> new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_description"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getString("product_name")
                        )).list();
    }

    public Product insert(Product product) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcClient.sql("INSERT INTO product( product_name , product_description , category , quantity , price) VALUES ( :product_name , :product_description , :category , :quantity , :price)")
                .params(Map.of(
                        "product_name",  product.getProduct_name(),
                        "product_description",  product.getProduct_description(),
                        "category",  product.getCategory(),
                        "quantity",  product.getQuantity(),
                        "price",  product.getPrice()
                ))
                .update(keyHolder);

        product.setProduct_id(Integer.parseInt(keyHolder.getKey().toString()));
        return product;
    }

    public Optional<Product> findById(Integer id) {
        return jdbcClient.sql("SELECT * FROM Product WHERE product_id = :id")
                .params(Map.of("id", id))
                .query((rs, rowNum) -> new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_description"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getString("product_name")
                )).optional();
    }

    public Optional<Product> update(Integer id, Product product) {
        int updateCount = jdbcClient.sql("UPDATE product SET  product_name = :product_name, product_description = :product_description , category = :category , quantity =:quantity , price =:price WHERE product_id = :product_id")
                .params(Map.of(
                           "product_id",id,
                        "product_name", product.getProduct_name(),
                        "product_description", product.getProduct_description(),
                        "category", product.getCategory(),
                        "quantity", product.getQuantity(),
                        "price", product.getPrice()
                ))
                .update();
        if (updateCount == 0) {
            return Optional.empty();
        }
        product.setProduct_id(id);
        return Optional.of(product);
    }

    public void deleteById(Integer id) {
        jdbcClient.sql("DELETE FROM product WHERE product_id = :id")
                .params(Map.of("id", id))
                .update();
    }

    public void saveAll (Iterable<Product> products) {

        products.forEach(this::insert);
    }

    public long count() {
        return (Long) jdbcClient.sql("SELECT COUNT(*) FROM product")
                .query()
                .singleValue();
    }

}
