# Expense Tracker

A CRUD web application to track personal expenses, built with Spring Boot and raw JDBC demonstrating Object-Oriented Programming concepts.

## Tech Stack

- **Backend:** Spring Boot 3.4.12
- **Database:** H2 (in-memory)
- **Frontend:** Thymeleaf + CSS
- **Data Access:** Raw JDBC with JdbcTemplate

## Features

- Add, edit, and delete expenses
- Categorize expenses (Food, Transport, Shopping, Bills, Entertainment, Other)
- View total expenses at a glance
- Clean, responsive UI

## OOP Concepts Demonstrated

| Concept | Implementation |
|---------|----------------|
| **Encapsulation** | Private fields with public getters/setters in `Expense.java` and `BaseEntity.java` |
| **Inheritance** | `Expense` extends `BaseEntity` abstract class |
| **Abstraction** | `IExpenseRepository` and `IExpenseService` interfaces hide implementation details |
| **Polymorphism** | `ExpenseRepository implements IExpenseRepository`, `ExpenseService implements IExpenseService` |

## Project Structure
```
src/main/java/com/eclipseX/expense/
├── model/
│   ├── BaseEntity.java          # Abstract class (inheritance)
│   └── Expense.java             # Extends BaseEntity (encapsulation)
├── repository/
│   ├── IExpenseRepository.java  # Interface (abstraction)
│   └── ExpenseRepository.java   # Implements interface (polymorphism)
├── service/
│   ├── IExpenseService.java     # Interface (abstraction)
│   └── ExpenseService.java      # Implements interface (polymorphism)
├── controller/
│   └── ExpenseController.java   # Handles HTTP requests
└── ExpenseApplication.java      # Entry point

src/main/resources/
├── templates/                   # Thymeleaf HTML templates
├── static/css/                  # Stylesheets
├── schema.sql                   # Database table creation
└── application.properties       # Configuration
```

## Architecture
```
┌─────────────┐     ┌─────────────┐     ┌─────────────┐     ┌──────────┐
│  Controller │────▶│   Service   │────▶│ Repository  │────▶│ Database │
│             │     │ (Interface) │     │ (Interface) │     │   (H2)   │
└─────────────┘     └─────────────┘     └─────────────┘     └──────────┘
```

## Running the App

1. Make sure you have Java 17+ installed
2. Clone the repo and navigate to the project folder
3. Run the application:
```bash
   ./mvnw spring-boot:run
```
4. Open `http://localhost:8081` in your browser

## Database

The app uses H2 in-memory database. Data resets on restart.

## About

This was built as a Java mini project demonstrating OOP concepts with Spring Boot and JDBC.

**Team:** eclipseX

**Project Idea:** Expense Tracker

**Collaborators:**
- [Harpreet](https://github.com/harpreet-2146/)
- [Haripriya](https://github.com/waterlilystar)