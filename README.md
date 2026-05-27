# SauceDemo UI & API Automation Framework

## Project Overview

This project is a Maven-based automation framework developed for UI and API testing.

The framework covers:

- UI Automation using Selenium WebDriver
- API Automation using RestAssured
- Page Object Model (POM) design pattern
- Externalized configuration using config.properties
- Explicit waits for synchronization
- Test execution using TestNG

Repository:
https://github.com/AzeezGit-cell/saucedemo-ui-api-automation-framework

---

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- RestAssured
- Maven
- WebDriverManager

---

## Project Structure

```text
project-root/
├── src/
│   ├── main/java/
│   │   ├── config/
│   │   ├── pages/
│   │   └── utils/
│   └── test/java/
│       └── tests/
├── src/main/resources/
│   └── config.properties
├── testng.xml
├── pom.xml
└── README.md
```

---

## UI Automation Scenario

Automated flow for SauceDemo:

1. Login with valid credentials
2. Add product to cart
3. Verify product in cart
4. Proceed to checkout
5. Verify checkout overview page

---

## API Automation Scenario

Automated flow for ReqRes API:

1. Register user and generate token
2. Extract and reuse token
3. Fetch user details using authenticated request
4. Validate response data

---

## Framework Design

The framework follows the Page Object Model (POM) design pattern to improve maintainability and readability.

Reusable utility classes were created for:
- WebDriver management
- Explicit waits
- Configuration handling

Configuration values such as URLs, credentials, and API data are externalized in the config.properties file to avoid hardcoding.

The framework is intentionally kept lightweight and simple based on assignment requirements.

---

## Setup Instructions

### Prerequisites

- Java 11 or above
- Maven installed
- Git installed

---

## Configuration

Update the ReqRes API key in `config.properties` before execution.

---

## Execute Tests

Run the following command from project root:

```bash
mvn clean test
```

---

## Assumptions

- Chrome browser is used for UI automation
- Internet connection is available during execution
- Valid ReqRes API key is configured in config.properties

---

## Author

Abdul Azeez Shaik