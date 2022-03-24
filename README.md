# dey-burrito-ordering-service
This service allows you to create order and getorders - application is written in Java SpringBoot with H2 in-memory database

Infairness i was using lombok for the first time, so it took me sometime to figure out it features and i read thru the documentation (I spend 1 hour 15 mins for this solution).
There are 2 Junit testcases for repository
There is a scope of more exception handling, and adding spring secutiy (JWT)



I went ahead and added a h2 database and exposing 3 end points
POST /order
GET /orders/{orderId}
GET /orders/allOrders


