package com.example.productinventory.productinventoryapp.service

import com.example.productinventory.productinventoryapp.event.MessageSender
import com.example.productinventory.productinventoryapp.event.ProductQuantityCreatedUpdatedEvent
import com.example.productinventory.productinventoryapp.model.ProductQuantity
import com.example.productinventory.productinventoryapp.repository.ProductPriceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductPriceServiceImpl
@Autowired constructor(val productPriceRepository: ProductPriceRepository,
                       val messageSender: MessageSender): ProductPriceService {
    override fun createProductQuantity(productQuantity: ProductQuantity): ProductQuantity {
        val createdProductPrice = productPriceRepository.save(productQuantity)
        messageSender.publishEvent(ProductQuantityCreatedUpdatedEvent(createdProductPrice))
        return createdProductPrice
    }
}