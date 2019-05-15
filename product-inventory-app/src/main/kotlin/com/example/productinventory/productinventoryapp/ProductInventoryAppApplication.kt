package com.example.productinventory.productinventoryapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProductInventoryAppApplication

fun main(args: Array<String>) {
	runApplication<ProductInventoryAppApplication>(*args)
}
