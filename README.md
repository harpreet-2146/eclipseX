# Expense Tracker

A simple CRUD web application to track personal expenses, built with Spring Boot and raw JDBC.

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

## Running the App

1. Make sure you have Java 17+ installed
2. Clone the repo and navigate to the project folder
3. Run the application:
```bash
   ./mvnw spring-boot:run
```
4. Open `http://localhost:8081` in your browser

## Project Structure
```
src/main/java/com/eclipseX/expense/
├── model/          # Expense entity
├── repository/     # JDBC database queries
├── service/        # Business logic
└── controller/     # HTTP routes

src/main/resources/
├── templates/      # Thymeleaf HTML templates
├── static/css/     # Stylesheets
├── schema.sql      # Database table creation
└── application.properties
```

## Database

The app uses H2 in-memory database. Data resets on restart.

## About

This was built as a Java mini project.

**Team:** eclipseX

**Project Idea:** Expense Tracker

**Collaborators:**
- [Harpreet](https://github.com/harpreet-2146/)
- [Haripriya](https://github.com/waterlilystar)
