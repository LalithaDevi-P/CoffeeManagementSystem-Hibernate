# Coffee Management System

A simple Coffee Management System built using Java, Hibernate ORM, and PostgreSQL. This project demonstrates CRUD operations and Hibernate relationships such as One-to-One and One-to-Many.

## Technologies Used

- Java 17
- Hibernate ORM 6
- PostgreSQL
- Maven

## How to Run

### 1. Clone the Repository

```bash
git clone <repository-url>
cd CoffeeManagementSystem
```

### 2. Create PostgreSQL Database

```sql
CREATE DATABASE coffee_shop;
```

### 3. Configure Hibernate

Create a file named:

```text
src/main/resources/hibernate.cfg.xml
```

Add your PostgreSQL credentials:

```xml
<property name="hibernate.connection.url">
    jdbc:postgresql://localhost:5432/coffee_shop
</property>

<property name="hibernate.connection.username">
    YOUR_USERNAME
</property>

<property name="hibernate.connection.password">
    YOUR_PASSWORD
</property>
```

### 4. Build the Project

```bash
mvn clean install
```

### 5. Run the Application

Run the `Main.java` file from your IDE or execute:

```bash
mvn exec:java
```

## Hibernate Configuration File

The `hibernate.cfg.xml` file contains:

- Database connection URL
- PostgreSQL username and password
- Hibernate dialect
- Table generation settings
- SQL logging configuration

**Note:** The actual `hibernate.cfg.xml` file is not included in this repository for security reasons. Create it locally using the sample configuration above.

## Features

- Product CRUD Operations
- Customer Management
- Customer Profile Management
- Coffee Order Management
- One-to-One Relationship (Customer ↔ CustomerProfile)
- One-to-Many Relationship (Customer → CoffeeOrder)

## Author

Lalitha
