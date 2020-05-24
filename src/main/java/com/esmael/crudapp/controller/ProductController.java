package com.esmael.crudapp.controller;

import com.esmael.crudapp.entity.Product;
import com.esmael.crudapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product)
    {
        return service.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products)
    {
        return service.saveProduct(products);
    }
    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id)
    {
    return  service.getProductById(id);
    }
    @GetMapping("/product/{name}")
    public Product getProductByName(@PathVariable String name)
    {
        return  service.getProductByName(name);
    }
    @GetMapping("/products")
    public List<Product> getProducts()
    {
     return service.getProducts();
    }
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product)
    {
     return service.updateproduct(product);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id)
    {
       return service.delete(id);
    }

}
