# Citizen-crud application
 Spring Boot CRUD application displays citizen and ambassador's data from MySQL and MongoDB, it also allows to interact with it. 
 The application is secured by Spring Security and encrypted in database by BCrypt.
 
## What and why did I do?
The project was created for my portfolio to demostrate my skills, it always gets updates during gained new knowledge.
+ There's created full-functional MVC citizen layer with repository and service logic, which interacts with MySQL and uses JPA(Hibernate) entity. Thymeleaf serves as engine for displaying view and transmitting data from Java.
+ Additionally was created restful ambassador layer, which also iteracts with repository, services, works with MongoDB and here's left http request methods for testing rest layer.
+ There's inside also rest documentation on basis of Swagger where's described rest end-points. 
+ To ease my life, I used Lombok library.

## Installation
 
``` 
In SQL folder were posted sql files with all wanted data for getting a quick access to project. 
You'll need insert them into MySQL and MongoDB
```

## Usage

```java
# You should enter username and passpord for MySQL database, if you have different.
# You'll also need to create database in MongoDB with the name "avgona_db" and "ambassadors" collection.

spring:
  datasource:
    jdbc-url: jdbc:mysql://localhost:3306/citizen_repository?useSSL=false&serverTimezone=UTC
    username: root
    password: 1234
  data:
    mongodb:
      uri: mongodb://localhost:27017/avgona_db
      
security:
  datasource:
    jdbc-url: jdbc:mysql://localhost:3306/citizen_security?useSSL=false&serverTimezone=UTC
    username: root
    password: 1234

```

#### **Technologies that were used**:
* Java 8
* Spring boot --- Spring Core, Spring Web(MVC, Rest), Spring Data, Swagger
* Spring Security --- JDBC authentication with encrypted passwords
* MySQL, MongoDB, JPA(Hibernate)
* Maven
* HTML, CSS, Thymeleaf, Boostrap
* Lombok

![Image of Maint](https://github.com/Avgona/Citizen-crud/blob/main/images/security.png?raw=true)

![Image of Maint](https://github.com/Avgona/Citizen-crud/blob/main/images/main.png?raw=true)

![Image of Maint](https://github.com/Avgona/Citizen-crud/blob/main/images/details.png?raw=true)

![Image of Maint](https://github.com/Avgona/Citizen-crud/blob/main/images/db.png?raw=true)

![Image of Maint](https://github.com/Avgona/Citizen-crud/blob/main/images/swagger-index.png?raw=true)

![Image of Maint](https://github.com/Avgona/Citizen-crud/blob/main/images/swagger-rests.png?raw=true)

![Image of Maint](https://github.com/Avgona/Citizen-crud/blob/main/images/mongodb.png?raw=true)
