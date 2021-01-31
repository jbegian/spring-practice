# spring-practice

Practice exercise provided via Baledung - [Building a Web Application with Spring Boot and Angular](https://www.baeldung.com/spring-boot-angular-web)

---

## Functionality

- Displays list of Users stored in in-memory database
- Adds User to in-memory database
- User Properties
  - id
  - name
  - email

## Features

- [Gradle 6.7.1](https://docs.gradle.org/current/userguide/userguide.html)
- [Spring Boot 2.4.2](https://spring.io/projects/spring-boot)
- [H2 In-memory Database](https://www.h2database.com/html/main.html)
- [Junit 5.7.0](https://junit.org/junit5/)
- [Java 11](https://docs.oracle.com/en/java/javase/11/)
- [Angular 11](https://angular.io/docs)

## Usage

- To build - `./gradlew clean build` from project root directory
- To run backend - `./gradlew bootRun` OR run utilizing editors runner/debugger
  - **NOTE** - If utilizing gradle to run project, ensure you are in project root folder
  - Backend runs on `localhost:8080`
- To run frontend - ng serve -o from `spring-practice\src\main\angular\client` directory
  - Frontend runs on `localhost:4200`
