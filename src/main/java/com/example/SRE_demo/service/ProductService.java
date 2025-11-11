package com.example.SRE_demo.service;

import com.example.SRE_demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    private final String BASE_URL = "https://fakestoreapi.com/products";

    @Autowired
    private RestTemplate restTemplate;

    public Product[] getAllProducts() {
        return restTemplate.getForObject(BASE_URL, Product[].class);
    }

    public Product getProductById(int id) {
        String url = BASE_URL + "/" + id;
        return restTemplate.getForObject(url, Product.class);
    }
}
