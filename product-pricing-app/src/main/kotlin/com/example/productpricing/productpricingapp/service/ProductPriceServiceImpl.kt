package com.example.productpricing.productpricingapp.service

import com.example.productpricing.productpricingapp.event.MessageSender
import com.example.productpricing.productpricingapp.event.ProductPriceAddedUpdatedEvent
import com.example.productpricing.productpricingapp.model.ProductPrice
import com.example.productpricing.productpricingapp.repository.ProductPriceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductPriceServiceImpl @Autowired  constructor(val productPriceRepository: ProductPriceRepository,
                                                      val messageSender: MessageSender): ProductPriceService {
    override fun createProductPrice(productPrice: ProductPrice): ProductPrice {
        val createdProductPrice = productPriceRepository.save(productPrice)
        messageSender.sendProcutPriceAddedUpdatedEvent(ProductPriceAddedUpdatedEvent(createdProductPrice))
        return createdProductPrice
    }
}