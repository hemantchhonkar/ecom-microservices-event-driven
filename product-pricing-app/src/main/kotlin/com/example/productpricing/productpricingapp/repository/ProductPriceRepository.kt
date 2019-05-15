package com.example.productpricing.productpricingapp.repository

import com.example.productpricing.productpricingapp.model.ProductPrice
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductPriceRepository: MongoRepository<ProductPrice, Long>