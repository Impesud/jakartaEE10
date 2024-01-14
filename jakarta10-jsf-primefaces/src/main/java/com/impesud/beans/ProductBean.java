package com.impesud.beans;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

import com.impesud.products.Product;
import com.impesud.products.ProductService;

@Named
@RequestScoped
public class ProductBean {

    @Inject
    private ProductService productService;

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = productService.findAll();
    }

    public List<Product> getProducts() {
        return products;
    }
}
