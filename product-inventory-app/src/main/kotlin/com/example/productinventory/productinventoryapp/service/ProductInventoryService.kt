package com.example.productinventory.productinventoryapp.service

import com.example.productinventory.productinventoryapp.model.ProductQuantity

interface ProductInventoryService {
    fun createProductQuantity(productQuantity: ProductQuantity): ProductQuantity
    fun getProducQuantity(productId: Long): ProductQuantity?
}