# 🧑‍💼 Employee Management System

A simple **Spring Boot** application using **JDBC with JdbcTemplate** to manage employees, their locations, and employee types.

> 🔧 Built with focus on clean code and basic JDBC operations without using JPA or Hibernate.

---

## 🚀 Tech Stack

- 🧩 Spring Boot
- 💾 MySQL
- 📦 Spring JDBC (`JdbcTemplate`)
- 🔗 REST API (Spring Web)
- 🐘 Maven

---

## 📁 Project Structure

src/ ├── controller/ # REST Controllers ├── service/ # Service Interfaces ├── service/impl/ # Service Implementations ├── dao/ # JDBC DAOs ├── model/ # Entity Models (POJOs) ├── util/ # Utility Classes (e.g., DB Connection) └── Application.java # Main Spring Boot App

yaml
Copy
Edit

---

## 🔌 Configuration

Update your `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
server.port=8080
📦 Maven Dependencies
Add these in your pom.xml:

xml
Copy
Edit
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jdbc</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
    </dependency>
</dependencies>
📚 API Endpoints
👤 Employee

Method	Endpoint	Description
GET	/employees	Get all employees
GET	/employees/{id}	Get employee by ID
POST	/employees	Create new employee
PUT	/employees/{id}	Update employee
DELETE	/employees/{id}	Delete employee
📍 Location

Method	Endpoint	Description
GET	/locations	Get all locations
POST	/locations	Create new location
💼 Employee Type

Method	Endpoint	Description
GET	/employee-types	Get all types
POST	/employee-types	Create new type
🧪 Sample JSON Payloads
Create Employee
json
Copy
Edit
{
  "firstname": "John",
  "lastname": "Doe",
  "salary": 5000,
  "status": "A",
  "employeeType": {
    "id": 1
  },
  "location": {
    "id": 2
  }
}
🏁 Run the App
bash
Copy
Edit
mvn spring-boot:run
Visit: http://localhost:8080

✅ Features
Create, Read, Update, Delete Employees

Manage Employee Types and Locations

Clean JDBC codebase without ORM

Easy to understand and extend

💡 Future Enhancements
Pagination and filtering

Validation and exception handling

Swagger/OpenAPI documentation

Unit tests and integration tests

👨‍💻 Author
Mahitosh (Mahi) — Spring Boot Developer

Feel free to connect or ask for enhancements!
