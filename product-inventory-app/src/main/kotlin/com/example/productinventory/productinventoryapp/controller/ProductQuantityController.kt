package com.example.productinventory.productinventoryapp.controller

import com.example.productinventory.productinventoryapp.model.ProductQuantity
import com.example.productinventory.productinventoryapp.service.ProductPriceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller("/productQuantities")
class ProductQuantityController @Autowired constructor(val productPriceService: ProductPriceService) {

    @PostMapping
    fun createProductPrice(@RequestBody productQuantity: ProductQuantity): ResponseEntity<ProductQuantity> {
        return ResponseEntity.ok(productPriceService.createProductQuantity(productQuantity))
    }
}