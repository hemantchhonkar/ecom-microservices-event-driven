package com.example.productinventory.productinventoryapp.service

import com.example.productinventory.productinventoryapp.model.ProductQuantity

interface ProductPriceService {
    fun createProductQuantity(productQuantity: ProductQuantity): ProductQuantity
}