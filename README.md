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
