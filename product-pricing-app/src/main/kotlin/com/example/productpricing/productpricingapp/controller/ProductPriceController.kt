package com.example.productpricing.productpricingapp.controller

import com.example.productpricing.productpricingapp.model.ProductPrice
import com.example.productpricing.productpricingapp.service.ProductPriceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller("/productPrices")
class ProductPriceController @Autowired constructor(val productPriceService: ProductPriceService) {

    @PostMapping
    fun createNewUpdateProductPrice(@RequestBody newProductPrice: ProductPrice): ResponseEntity<ProductPrice> {
        return ResponseEntity.ok(productPriceService.createProductPrice(newProductPrice))
    }
}