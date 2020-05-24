package com.esmael.crudapp.service;

import com.esmael.crudapp.entity.Product;
import com.esmael.crudapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    public ProductRepository productRepository;
    public Product saveProduct(Product product)
    {
        return productRepository.save(product);
    }
    public List<Product> saveProduct(List<Product> products)
    {
        return productRepository.saveAll(products);
    }
    public List<Product> getProducts()
    {
        return productRepository.findAll();
    }
    public Product getProductById(int id)
    {
        return productRepository.findById(id).orElse(null);
    }
    public Product getProductByName(String name)
    {
        return productRepository.findByName(name);
    }
    public String delete(int id)
    {
       productRepository.deleteById(id);
       return "product deleted "+id;
    }
    public Product updateproduct(Product product)
    {
     Product existingProduct=productRepository.findById(product.getId()).orElse(null);
     existingProduct.setName(product.getName());
     existingProduct.setPrice(product.getPrice());
     existingProduct.setQuantity(product.getQuantity());
     return productRepository.save(existingProduct);
    }
}
