# Star Wars Planets API 🌌

The **Star Wars Planets API** is a RESTful API that allows users to manage Star Wars planets. It performs CRUD operations and integrates with the public [SWAPI](https://swapi.dev/) to retrieve the number of times a planet has appeared in Star Wars movies.

## 🚀 Features

- **Add Planets**: Register planets with name, climate, and terrain.
- **List Planets**: Retrieve a list of all registered planets.
- **Search by ID or Name**: Find planets by their ID or name using a single search endpoint.
- **Delete Planet**: Remove planets from the database.
- **Movie Appearances**: Automatically fetch the number of movie appearances for each planet from the SWAPI.

## 🛠️ Technologies

This project was built with the following technologies:

- **Java 17**: To build the application.
- **Spring Boot 3**: For creating the RESTful API.
- **Spring Data JPA**: For database interactions and dynamic queries.
- **Flyway**: For database migrations.
- **MySQL**: For storing planet data.
- **Lombok**: To simplify Java code with annotations.
- **JUnit**: For unit testing.

## 📚 API Documentation

The API is documented using **SpringDoc OpenAPI**. You can access the documentation at `http://localhost:8080/swagger-ui.html` after starting the application.

## 📄 API Endpoints Overview

- **Create Planet**
  - `POST /api/planets`: Add a new planet with name, climate, and terrain.
  
- **List Planets**
  - `GET /api/planets`: Retrieve a list of all registered planets.
  
- **Search Planet by ID or Name**
  - `GET /api/planets?search={id_or_name}`: Search for a planet by either its ID (as a number) or name (as a string). If the search term is a number, the API assumes it's an ID; otherwise, it searches by name.

- **Delete Planet**
  - `DELETE /api/planets/{id}`: Delete a planet from the database.

## 💾 Database

The project uses **MySQL** to store planet data, with **Flyway** managing database migrations. You can configure the database settings in the `application.properties` file.

## 📝 Author

This project was developed by **Luiz Almeida** based on the [Ame Digital Back-end Challenge](https://github.com/AmeDigital/challenge-back-end-hit), showcasing skills in building RESTful APIs with Spring Boot.
