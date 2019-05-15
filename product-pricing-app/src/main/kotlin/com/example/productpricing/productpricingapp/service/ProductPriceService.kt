package com.example.productpricing.productpricingapp.service

import com.example.productpricing.productpricingapp.model.ProductPrice

interface ProductPriceService {
    fun createProductPrice(productPrice: ProductPrice): ProductPrice
}