# Level 1, CRUD with H2
Access the page ->https://start.spring.io/, and generate a Spring boot project with the following characteristics:

- PROJECT (dependency manager): Maven or Gradle
- LANGUAGE: Java
- SPRING BOOT: The latest stable version
- PROJECT METADATA
  - Group: cat.itacademy.barcelonactiva.surnames.name.s04.t02.n01
  - artifact: S04T02N01GognomesName
  - Name: S04T02N01GognomesName 
  - Description: S04T02N01GognomesName
  - Package name: cat.itacademy.barcelonactiva.surnames.name.s04.t02.n01
- PACKAGING: Jar
- JAVA: Minimum version 11
- Dependencies:
  - Spring Boot DevTools
  - Spring Web
  - Spring Data JPA
  - H2 Database

We have an entity called "Fruit", which has the following properties:
- int id
- String name
- Int quantityKilos

Taking advantage of the JPA specification, you will have to persist this entity to an H2 database, following the MVC pattern. For this, depending on the main Package, you will create a package structure, where you will place the classes you need:

- cat.itacademy.barcelonactiva.surnames.name.s04.t02.n01.controllers
- cat.itacademy.barcelonactiva.surnames.name.s04.t02.n01.model.domain
- cat.itacademy.barcelonactiva.surnames.name.s04.t02.n01.model.services
- cat.itacademy.barcelonactiva.surnames.nom.s04.t02.n01.model.repository

The class located in the controllers package (FruitaController, for example), must be able to respond to the following requests to update and consult information:

http://localhost:8080/fruit/add

http://localhost:8080/fruit/update

http://localhost:8080/fruita/delete/{id}

http://localhost:8080/fruita/getOne/{id}

http://localhost:8080/fruit/getAll