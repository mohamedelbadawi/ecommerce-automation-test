# E-Commerce Automation Testing

## Project Overview
This project is an automated test suite for an e-commerce application using TestNG and Selenium WebDriver. It follows the **Page Object Model (POM) design pattern** to enhance maintainability and reusability.

## Technologies Used
- **Java** (Programming Language)
- **TestNG** (Testing Framework)
- **Selenium WebDriver** (Automation Tool)
- **Allure Reports** (Test Reporting)
- **Maven** (Build Tool)
- **SLF4J & Logback** (Logging)

## Project Structure
The project is structured as follows:
- `tests/` - Contains test classes for different modules.
- `pages/` - Contains Page Object Model (POM) classes representing different pages.
- `utils/` - Contains utility classes for common functions.
- `resources/` - Configuration files and test data.

## Test Modules & Scenarios
### 1. **Login Tests**
- Verify login with a valid email and password.
- Verify login with an invalid password.
- Verify login with an invalid email.
- Verify login with empty credentials.

### 2. **Product Tests**
- Verify searching for an existing product.
- Verify searching for a non-existent product.

### 3. **Cart Tests**
- Verify adding a product to the cart.
- Verify removing a product from the cart.
- Verify the cart is empty on the first visit.
- Verify adding a product with a specific quantity.

### 4. **Checkout Tests**
- Verify a successful checkout when logged in.


## Reports
- After test execution, generate an Allure report by running:
  ```sh
  mvn allure:report
  mvn allure:serve
  ```
