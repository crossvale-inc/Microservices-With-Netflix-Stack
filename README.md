# Microservices-With-Netflix-Stack
A repository to hold labs for learning Spring Cloud development using Netflix tools. 
Each lab goes over a different component of the stack, with an additional example application that brings them all together.

Lab01_Hystrix: Hystrix setup, used for latency/fault tolerance, wrapping calls with fallback methods in case of failure

Lab02_Eureka: Eureka Server setup, used for discovery

Lab03_Ribbon: Ribbon setup, used for client-side load balancing, either specifying a group of servers to choose from, or using Eureka's service discovery to choose for you

Lab04_Zuul: Zuul setup, used for proxying all calls to backend services, either relying on Eureka for service discovery or specifying servers explicitly. Uses Ribbon internally for load-balancing without having to setup

Lab05_Archaius: Archaius setup, used for dynamically changing configuration properties

Lab06_ Feign: Feign setup, used for more easily creating REST controllers

Lab07_Bonus_Swagger: Swagger setup; not part of the Netflix stack, but helpful in easily creating API documentation /testing tools

Lab08_Example_Application: An application that brings all of the other labs together into one coherent application
