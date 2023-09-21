package com.spring_crud.demo.service;

import com.spring_crud.demo.entity.Product;
import com.spring_crud.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl {

    @Autowired
    private ProductRepository productRepository;

    public  Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(Product product) {
        Product myProduct = productRepository.findById(product.getId()).orElse(null);
        myProduct.setName(product.getName());
        myProduct.setPrice(product.getPrice());
        myProduct.setQuantity(product.getQuantity());

        return productRepository.save(myProduct);
    }

    public String deleteProductById(int id) {
        productRepository.deleteById(id);

        return "product with id: " + id + " deleted";
    }
}
