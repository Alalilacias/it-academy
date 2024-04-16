# Level 1, Web CRUD App with MySQL
Access the page ->https://start.spring.io/, and generate a Spring boot project with the following characteristics:

- PROJECT (dependency manager): Maven or Gradle
- LANGUAGE: Java
- SPRING BOOT: The latest stable version
- PROJECT METADATA
    - Group: cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01
    - artifact: S05T01N01GognomesName
    - Name: S05T01N01GognomesName
    - Description: S05T01N01GognomesName
    - Package name: cat.itacademy.barcelonactiva.surnames.name.s05.t01.n01
- PACKAGING: Jar
- JAVA: Minimum version 11
- Dependencies:
    - Spring Boot DevTools
    - Spring Web
    - Spring Data JPA
    - MySQL Driver
    - Thymeleaf

We have an entity called Branch, which has the following properties:

- Integer pk_BranchID

- String nameBranch

- String countryBranch

We also have a DTO called BranchDTO, which will have the same properties as the Branch entity, adding one:

- String typeBranch.

This property, depending on the country of the branch, must indicate whether it is "EU" or "Non-EU". To do this, you can have a private list in the same DTO (for example: List<String> countries), with the countries that are part of the EU.

Taking advantage of the JPA specification, you will have to persist the Branch entity to a MySql database, following the MVC pattern.
> The recommendation is that you use BranchDTO in the Controller and the View, and Branch in the Repository. The service layer will be in charge of translating between the two.

The following package structure is recommended:

- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.controllers

- cat.itacademy.barcelonactiva.surnames.nom.s05.t01.n01.model.domain

- cat.itacademy.barcelonactiva.surnames.name.s05.t01.n01.model.dto

- cat.itacademy.barcelonactiva.surnames.nom.s05.t01.n01.model.services

- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.repository

The class located in the controllers package (BranchController, for example), must be able to respond to the following requests to update and consult information:

http://localhost:9000/branch/add

http://localhost:9000/branch/update

http://localhost:9000/sucursal/delete/{id}

http://localhost:9000/sucursal/getOne/{id}

http://localhost:9000/branch/getAll

The port to be used is 9000.

The view must be developed with Thymeleaf.

> Swagger has been implemented on this project and it can be accessed through the following link: http://localhost:9000/swagger-ui.html
