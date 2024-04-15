# Level 3, REST API connected to another REST API
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
- Dependencies:
    - Spring Boot DevTools
    - Spring Web

Using RestTemplate or WebClient, connect to the API you made in level 2, to call and test all the requests that this API allows.

Note, that in this level 3 task, you have no reference to any database, nor do you need to use JPA, as your repository will access the level 2 API.

You don't need to create a View, because this level 3 is planned as a Rest API, but you will need to create all the layers up to the controller like any other application:

- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.controllers

- cat.itacademy.barcelonactiva.surnames.nom.s05.t01.n03.model.domain

- cat.itacademy.barcelonactiva.surnames.name.s05.t01.n03.model.dto

- cat.itacademy.barcelonactiva.surnames.nom.s05.t01.n03.model.services

- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.model.repository



The controller class must be able to handle the following requests:

http://localhost:9003/flor/clientFlorsAdd
http://localhost:9003/flor/clientFlorsUpdate
http://localhost:9003/flor/clientFlorsDelete/{id}
http://localhost:9003/flor/clientFlorsGetOne/{id}
http://localhost:9003/flor/clientFlorsAll



The port to use is 9002.

To test level 3, you'll need to have the level 2 API running. It is important that these two are configured to different ports, as instructed.