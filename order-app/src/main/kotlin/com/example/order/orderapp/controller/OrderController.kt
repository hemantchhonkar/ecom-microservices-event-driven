package com.example.order.orderapp.controller

import com.example.order.orderapp.model.ProductOrder
import com.example.order.orderapp.service.ProductOrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody


@Controller("/orders")
class OrderController @Autowired constructor(val productOrderService: ProductOrderService) {

    @PostMapping
    fun createNewOrder(@RequestBody newOrder: ProductOrder): ResponseEntity<ProductOrder> {
        return ResponseEntity.ok(productOrderService.createOrder(newOrder))
    }

    @GetMapping
    fun getListOfAllOrders(): ResponseEntity<List<ProductOrder>>{
        return ResponseEntity.ok(productOrderService.getAllOrders())
    }
}