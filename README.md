# TDX Automation Project

This project automates tests for the TDX web application. It includes tests for user sign-up functionality and for validating Swagger UI API responses. The project is built using Maven and TestNG, following best practices for test automation.

## Table of Contents
- [General Information](#general-information)
- [Project Structure](#project-structure)
- [Dependencies](#dependencies)
- [Running Tests](#running-tests)
- [TestNG Suite](#testng-suite)
- [Contributing](#contributing)
- [Author](#author)


## General Information
- **Project Purpose**: Automate tests for TDX web application, including user sign-up and Swagger UI API validation.
- **Tests Implemented**:
  1. **Sign-Up Test**: Verifies the correct sign-up functionality and redirection to the main page.
  2. **Swagger UI API Test**: Validates the API response code and body for Swagger UI.
- **Design Pattern**: Follows a structured test organization with base and specific test classes.

## Project Structure
```plaintext
TDXAutomation/
├── src/
│   ├── main/
│   │   └── java/
│   ├── test/
│   │   └── java/
│   │       └── org/
│   │           └── TDX/
│   │               ├── configuration/
│   │               ├── pages/
│   │               ├── reporting/
│   │               ├── tests/
│   │               └── utils/
├── suite.xml
├── pom.xml
└── README.md
```
## Dependencies
This project uses the following dependencies:
- **TestNG**: 6.14.2
- **WebDriverManager**: 5.3.1
- **Selenium**: 4.5.3
- **SLF4J**: 2.0.3
- **JSON**: 20210307

Dependencies are defined in the `pom.xml` file.

## Running Tests
Tests are configured to run via TestNG. To execute the tests, use the following Maven command:
```sh
mvn test
```
## Contributing

Contributions are welcome! Please fork the repository and submit a pull request.

Fork the repository.
Create your feature branch (git checkout -b feature/YourFeature).
Commit your changes (git commit -m 'Add your feature').
Push to the branch (git push origin feature/YourFeature).
Open a pull request.

## Author

Jinson Stevenson Moreno Aguilar - jinson.moreno@gmail.com
