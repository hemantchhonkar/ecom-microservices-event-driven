# ecom-microservices-event-driven
This project contains multiple microservices to demonstrate how to use events with Rabbit MQ to communicate between services 

## Tools used
- Kotlin
- Spring Boot
- MongoDB
- Rabbit MQ


## Installation (MongoDB and Rabbit MQ)
To start a Rabbit MQ container with management console

```
docker run -d --hostname my-rabbit --name test-rabbit-mq -p 5672:5672  -p 15672:15672 rabbitmq:3-management
```

To start a MongoDB container

```
docker run -d --name ecom-mongo -p 27017:27017 mongo
```

## Enpoints and request payloads

- Search Service

```
GET http://localhost:8081/productSearch

```
- Product Service

```
GET/POST http://localhost:8082/products

{
	"productId" : 1,
	"productName" : "MacBook Pro",
	"productSpecification" : "Intel i5 Turbo"
}

```
- Product Inventory

```
POST http://localhost:8083/productQuantities

{
	"productId" : 1,
	"quantity" : 87
}

```
- Product Pricing

```
POST http://localhost:8084/productPrices

{
	"productId" : 1,
	"price" : 1000000
}

```

- Product Order

```
GET/POST http://llocalhost:8085/orders

{
	"orderId" : 12311,
	"productId" : 1,
	"userId" : 99999,
	"quantity" : 7
}

```
