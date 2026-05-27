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

Automated API test scenarios for ReqRes:

### Test 1: Authentication & Token Generation

- POST `/api/register`
- Validate status code `200`
- Extract authentication token from response
- Store token for subsequent API requests

### Test 2: Authenticated User Validation

- GET `/api/users/2`
- Pass Bearer token in Authorization header
- Validate status code `200`
- Validate user ID and email response data

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

- Java
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