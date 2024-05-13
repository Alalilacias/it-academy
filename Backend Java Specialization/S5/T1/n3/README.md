# Level 2, REST API CRUD with MySQL
Access the page ->https://start.spring.io/, and generate a Spring boot project with the following characteristics:

- PROJECT (dependency manager): Maven or Gradle
- LANGUAGE: Java
- SPRING BOOT: The latest stable version
- PROJECT METADATA
    - Group: cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03
    - artifact: S05T01N03GognomesName
    - Name: S05T01N03GognomesName
    - Description: S05T01N03GognomesName
    - Package name: cat.itacademy.barcelonactiva.surnames.name.s05.t01.n03
- PACKAGING: Jar
- JAVA: Minimum version 11
- DEPENDENCIES: 
  - Spring Boot DevTools
  - Spring Web


Using RestTemplate or WebClient, you will need to connect to the API you made in level 2, to call and test all the requests that this API allows.

Note, that in this level 3 task, you have no reference to any database, nor do you need to use JPA, as your repository will access the level 2 API.

You don't need to create a View, because this level 3 is intended as a Rest API, but you will need to create all the layers up to the controller like any other application:

- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.controllers

- cat.itacademy.barcelonactiva.surnames.nom.s05.t01.n02.model.domain

- cat.itacademy.barcelonactiva.surnames.name.s05.t01.n02.model.dto

- cat.itacademy.barcelonactiva.surnames.nom.s05.t01.n02.model.services

- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.repository

The controllers class must be able to answer to the following requests:

http://localhost:9003/flower/addClient

http://localhost:9003/flower/updateClient

http://localhost:9003/flower/deleteClient/{id}

http://localhost:9003/flower/getOneClient/{id}

http://localhost:9003/flower/getAllClient

The server's port must be set to 9003.

To test level 3, you'll need to have the level 2 API running. You won't have any problems, since the level 3 API works with port 9002 and the level 2 API with port 9001.

> Swagger must be implemented on this project, and it should be accessible through the following link: http://localhost:9003/swagger-ui/index.html