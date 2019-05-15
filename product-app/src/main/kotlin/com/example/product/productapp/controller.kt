package com.example.product.productapp

import com.example.product.productapp.model.Product
import com.example.product.productapp.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody


@Controller("/products")
class ProductController @Autowired constructor(val productService: ProductService){

    @PostMapping
    fun createProduct(@RequestBody newProduct: Product): ResponseEntity<Product>{
        return ResponseEntity.ok(productService.createProduct(newProduct))
    }

    @GetMapping
    fun listAllProducts(): ResponseEntity<List<Product>> {
        return ResponseEntity.ok(productService.getAllProducts())
    }
}