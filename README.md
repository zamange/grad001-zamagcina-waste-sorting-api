
# Grad001 Zamagcina Waste Sorting API

Welcome to the Grad001 Zamagcina Waste Sorting API project! This Spring Boot application is designed to provide a REST API for the Enviro365 waste sorting mobile application. The goal is to facilitate data exchange between the mobile frontend and the backend server, empowering users with proper waste disposal techniques and recycling tips.

## Project Overview

Enviro365 is an environmental solutions company focused on sustainable waste management practices. This application serves as an educational tool to promote proper waste disposal and encourage recycling. As part of the team, you will develop and expose RESTful APIs using Spring Boot for functionalities like:

- Waste category lookup
- Disposal guidelines retrieval
- Recycling tips display

This repository contains the backend logic, implemented in Java with Spring Boot, to provide these services through an API.

## Features

- **RESTful APIs** for handling waste category, disposal guideline, and recycling tip data.
- **CRUD Operations** to create, read, update, and delete waste-related data.
- **Structured JSON Responses** to facilitate communication between the mobile frontend and the backend.
- **Input Validation** to ensure data integrity using Spring Boot validation annotations.

## Project Setup

To run the project, you need to have the following:

- Java 11 or later
- Maven
- Spring Boot

### Clone the Repository

```bash
git clone https://github.com/zamange/grad001-zamagcina-waste-sorting-api.git
cd grad001-zamagcina-waste-sorting-api
```

### Run the Application

You can easily compile, clean, and run the application using the provided Makefile.

#### Available Make Commands:

- **Clean the project:**

```bash
make clean
```

- **Compile the project:**

```bash
make compile
```

- **Run the application (starts Spring Boot):**

```bash
make run
```

The Makefile ensures that all necessary Maven commands are executed, and the project is run from the `zamagcina-ngeyane` directory. The Spring Boot application will be available and running on the default port (usually 8080).

## Accessing the API

Once the application is running, you can interact with the exposed API endpoints.

#### Example Endpoints:

- **Get all waste categories:**

  - URL: `/api/waste-categories`
  - Method: `GET`
  - Response: A list of waste categories in JSON format.

- **Get a specific waste category by ID:**

  - URL: `/api/waste-categories/{id}`
  - Method: `GET`
  - Response: A single waste category in JSON format.

- **Get all disposal guidelines:**

  - URL: `/api/disposal-guidelines`
  - Method: `GET`
  - Response: A list of disposal guidelines in JSON format.

- **Get a specific recycling tip:**

  - URL: `/api/recycling-tips/{id}`
  - Method: `GET`
  - Response: A single recycling tip in JSON format.

## Error Handling

The API includes error handling to ensure that appropriate error messages are returned when something goes wrong. The response will include error codes and messages in a structured format.

## Validation

Input data for creating or updating waste categories, disposal guidelines, and recycling tips is validated using Spring Boot's built-in validation annotations.

## Directory Structure

- **src/main/java**: Contains all Java source files, including:
  - `com/enviro/assessment/grad001/zamagcina_ngeyane/entity`: Entities for WasteCategory, DisposalGuideline, and RecyclingTip.
  - `com/enviro/assessment/grad001/zamagcina_ngeyane/controller`: REST controllers for handling API requests.
  - `com/enviro/assessment/grad001/zamagcina_ngeyane/service`: Service layer containing business logic.
  - `com/enviro/assessment/grad001/zamagcina_ngeyane/repository`: Repository interfaces for database interaction.
  
- **src/main/resources**: Contains configuration files, such as `application.properties`.

## Contributing

Feel free to contribute to this project by submitting pull requests. For any issues or enhancements, please create an issue in the GitHub repository.
