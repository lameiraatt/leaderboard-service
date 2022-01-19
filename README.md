# Leaderboard Service

This service is for managing users on the leaderboard

This app connects to an H2 DB service that manages database connections and connects to market data service that executes trading functions.
Simple [Spring Boot](http://projects.spring.io/spring-boot/)

[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![Coverage Status](https://coveralls.io/repos/github/codecentric/springboot-sample-app/badge.svg?branch=master)](https://coveralls.io/github/codecentric/springboot-sample-app?branch=master)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)



## Requirements

For building and running the application you need:

- [`JDK 11`](https://www.oracle.com/java/technologies/downloads/#java11)
- [`Gradle `](https://gradle.org/install/)

## Dependencies
- [`Spring Starter Web`]()
- [`h2`]()
- [`Lambook`]()



## Running the application locally

_Set Environment_
```properties
server.port=8080
```

_Running the Application_

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.jhid.orderprocessing.Application` class from your IntelliJ IDE.

Alternatively you can use the [`Spring Boot Gradle`](https://docs.gradle.org/current/userguide/multi_project_builds.html) like so:

```shell
gradle -q run
```

## Using the Application

Application is embedded with Spring Security, thus a User must sign up and logIn to gain Access
- [`Sign Up UR`L](https://order-processing-v1.herokuapp.com/sign-up)
- [`Login URL`](https://order-processing-v1.herokuapp.com/login)


## Copyright

Released under the MIT License 2.0. See the [`LICENSE`](https://github.com/jhid-trading/trade-db-service/blob/development/LICENSE) file.
