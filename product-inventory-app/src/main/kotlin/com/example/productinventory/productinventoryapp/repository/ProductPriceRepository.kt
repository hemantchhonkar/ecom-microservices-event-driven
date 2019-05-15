package com.example.productinventory.productinventoryapp.repository

import com.example.productinventory.productinventoryapp.model.ProductQuantity
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductPriceRepository: MongoRepository<ProductQuantity, Long>