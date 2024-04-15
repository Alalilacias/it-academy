# Level 2, REST API CRUD with MySQL
Access the page ->https://start.spring.io/, and generate a Spring boot project with the following characteristics:

- PROJECT (dependency manager): Maven or Gradle
- LANGUAGE: Java
- SPRING BOOT: The latest stable version
- PROJECT METADATA
    - Group: cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02
    - artifact: S05T01N02GognomesName
    - Name: S05T01N02GognomesName
    - Description: S05T01N02GognomesName
    - Package name: cat.itacademy.barcelonactiva.surnames.name.s05.t01.n01
- PACKAGING: Jar
- JAVA: Minimum version 11
- Dependencies:
    - Spring Boot DevTools
    - Spring Web
    - Spring Data JPA
    - MySQL Driver

We have an entity called FlowerEntity, which has the following properties:

- Integer pk_FlowerID

- String flowerName

- String flowerCountry

We also have a DTO called FlorDTO, which will have the same properties as the Branch entity, adding one:

- String flowerType

This property, depending on the country of origin of the flower, must indicate whether it is "EU" or "Non-EU". To do this, you can have a private list in the same DTO (for example: List<String> countries), with the countries that are part of the EU.

Taking advantage of the JPA specification, you will have to persist the FlowerEntity entity to a MySQL database, following the MVC pattern.

> It is recommended to use the FlowerDTO in the Controller, and FlowerEntity in the Repository. The service layer will be in charge of translating between the two.

The following package structure is recommended:

For this, depending on the main package, you will create a package structure, where you will place the classes you need:

- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.controllers

- cat.itacademy.barcelonactiva.surnames.nom.s05.t01.n02.model.domain

- cat.itacademy.barcelonactiva.surnames.name.s05.t01.n02.model.dto

- cat.itacademy.barcelonactiva.surnames.nom.s05.t01.n02.model.services

- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.repository

The class located in the controllers package (FlowerController, for example), must be able to respond to the following requests to update and consult information:

http://localhost:9002/flower/add

http://localhost:9002/flower/update

http://localhost:9002/flower/delete/{id}

http://localhost:9002/flower/getOne/{id}

http://localhost:9002/flower/getAll

The port to be used is 9002.

> **Important**\
> You should include swagger so that any developer can get a quick idea of ​​the resources available in the API.