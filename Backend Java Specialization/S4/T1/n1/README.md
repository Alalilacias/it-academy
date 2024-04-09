# Level 1, Maven Project
This exercise is a first contact with Spring and Maven. The instructions are as follows:

Access the page ->https://start.spring.io/, and generate a Spring boot project with the following characteristics:


- PROJECT (dependency manager): maven
- LANGUAGE: Java.
- SPRING BOOT: The latest stable version.
- PROJECT METADATA
  - Group: cat.itacademy.barcelonactiva.surnames.name.s04.t01.n01
  - artifact: S04T01N01NamesNom 
  - Name: S04T01N01NamesNom 
  - Description: S04T01N01NamesNom 
  - Package name: cat.itacademy.barcelonactiva.surnames.name.s04.t01.n01 
- PACKAGING: Jar 
- JAVA: Minimum version 11
- Dependencies:
  - Spring Boot DevTools
  - Spring Web

Import it into Eclipse using File > Import > Existing Maven Project.

In the application.properties file, set the server.port variable to 9000.

We'll turn this application into a REST API:
Depending on the main package, create another subpackage called Controllers, and inside it, add the HelloWorldController class.


It should have two methods:
String greets
String greets2

These two methods will receive a String parameter named name, and return the phrase:

“Hello, “ + name + “. You are running a Maven project”.


The first method will respond to a GET request, and must be configured to receive the parameter as a RequestParam. The "name" parameter will have the default value "UNKNOWN".

You will have to answer to:

http://localhost:9000/HelloWorld
http://localhost:9000/HelloWorld?name=My name



The second method will respond to a GET request, and must be configured to receive the parameter as a PathVariable. The "name" parameter will be optional.

You will have to answer to:

http://localhost:9000/HelloWorld2
http://localhost:9000/HelloWorld2/myname