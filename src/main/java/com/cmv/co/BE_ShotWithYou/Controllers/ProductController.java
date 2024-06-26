package com.cmv.co.BE_ShotWithYou.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.cmv.co.BE_ShotWithYou.Model.Product;
import com.cmv.co.BE_ShotWithYou.NotFoundException.ProductNotFoundException;
import com.cmv.co.BE_ShotWithYou.Repository.ProductRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ProductController {

    ProductRepository repo;

    //constructor
    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    //http://127.0.0.1/products
    //Get all products
    @GetMapping("/products")
    public List<Product> getProducts(){
        return repo.findAll();
    }
    
    //http://127.0.0.1:8080/product/{id}
    @GetMapping("/product/{id}")
     public Product geProduct(@PathVariable Long id){
         return repo.findById(id)
        .orElseThrow(()-> new ProductNotFoundException(id));
     }

    //http://127.0.0.1:8080/product/new
    @PostMapping("/product/new")
    public String addProduct(@RequestBody Product newProduct){
        repo.save(newProduct);
        return "A new product is added. Yey!";
    }

    //Update Endpoints
    //http://127.0.0.1:8080/product/edit/{id}/1
    @PutMapping("/product/edit/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product newProduct){
        return repo.findById(id)
        .map(product ->{
            product.setProductName(newProduct.getProductName());
            product.setDescription(newProduct.getDescription());
            product.setPrice(newProduct.getPrice());
            return repo.save(product);
        }).orElseGet(()->{
            return repo.save(newProduct);
        });
    }

    //Delete Endpoints
    //http://127.0.0.1:8080/product/delete/1
    @DeleteMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        repo.deleteById(id);
        return "A product is Deleted!";
    }
}
