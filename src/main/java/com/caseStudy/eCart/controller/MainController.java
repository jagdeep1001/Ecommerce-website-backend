package com.caseStudy.eCart.controller;


import com.caseStudy.eCart.model.Products;

import com.caseStudy.eCart.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class MainController {

    @Autowired
    ProductService productService;


    @GetMapping("/products")
    public List<Products> getAllProducts() { return productService.getProductList(); }

    @GetMapping("/productsFrom/{category}")
    public List<Products> getProductCategory(@PathVariable("category") String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/product-detail/{id}")
    public Optional<Products> getProduct(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }

    @PostMapping("/addProduct")
    @ResponseBody
    public Products addProduct(@RequestBody Products product) {
        return productService.addOneProduct(product);
    }

    @GetMapping("/products/{id}/delete")
    public List<Products> deleteProduct(@PathVariable("id") Long id)
    {
        return productService.deleteProduct(id);
    }


    @GetMapping("/products/{category}/{price1}/{price2}")
    public List<Products> getCategoryAndPrice(@PathVariable(value = "category")String category,
                                              @PathVariable(value = "price1")Double price1,
                                              @PathVariable(value = "price2")Double price2) {
        return productService.getProductsByCategoryAndPrice(category, price1, price2);
    }

    @GetMapping("/products/{price1}/{price2}")
    public List<Products> getPrice(@PathVariable(value = "price1")Double price1,
                                   @PathVariable(value = "price2")Double price2) {
        return productService.getProductsByPrice(price1, price2);
    }

    @PostMapping("/editProduct")
    public Products editUsers(@RequestBody Products products)
    {
        return productService.changeProductDescriptions(products);
    }

    @GetMapping("/search/{searchedItem}")
    public Set<Products> searchItem(@PathVariable("searchedItem") String searchedItem) {
        Set<Products> prod = productService.getSearchedData(searchedItem);
        for (int i = 0; i < prod.size(); i++) {
            System.out.println(prod);
        }
        return prod;
    }


}
