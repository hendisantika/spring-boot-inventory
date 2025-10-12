# Spring Boot Inventory Management System

A web-based inventory management system built with Spring Boot 3.5.6, JPA/Hibernate, Thymeleaf, and MySQL/H2 database.

## Features

- User Management (CRUD operations)
- Product Management with categories and brands
- Product details tracking
- Brand and Category management
- Shopping cart functionality
- Responsive web interface with Thymeleaf templates

## Technologies Used

- **Spring Boot 3.5.6** (Java 21)
- **Spring Data JPA** with Hibernate 6.6.29
- **Thymeleaf** for server-side rendering
- **MySQL 8** (production) / **H2** (development)
- **Lombok** for reducing boilerplate code
- **Maven** for dependency management

## Prerequisites

- **Java 21** or higher
- **Maven 3.6+**
- **MySQL 8** (for production) or Docker (optional)

## Getting Started

### Option 1: Run with H2 In-Memory Database (Development)

This is the quickest way to run the application for development/testing:

```bash
# Clone the repository
git clone https://github.com/hendisantika/spring-boot-inventory.git

# Navigate to the project directory
cd spring-boot-inventory

# Run with dev profile (uses H2 in-memory database)
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

The application will start on `http://localhost:8080`

**H2 Console:** Access at `http://localhost:8080/h2-console`

- JDBC URL: `jdbc:h2:mem:inventory`
- Username: `sa`
- Password: (leave empty)

### Option 2: Run with MySQL (Production)

#### Using Docker Compose (Recommended)

```bash
# Start MySQL database
docker-compose up -d

# Wait for MySQL to be ready, then run the application
mvn spring-boot:run
```

#### Using Local MySQL Installation

1. Make sure MySQL is running on your system
2. Update `src/main/resources/application.properties` if needed:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/inventory?createDatabaseIfNotExist=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Jakarta&useSSL=false
   spring.datasource.username=root
   spring.datasource.password=root
   ```
3. Run the application:
   ```bash
   mvn clean spring-boot:run
   ```

### Building for Production

```bash
# Build the JAR file
mvn clean package

# Run the JAR
java -jar target/spring-boot-inventory-0.0.1-SNAPSHOT.jar
```

## Application Structure

```
src/main/java/com/hendisantika/
├── SpringBootInventoryApplication.java  # Main application class
├── AppController.java                   # Home controller
├── user/                                # User module
├── product/                             # Product module
├── brand/                               # Brand module
├── category/                            # Category module
└── articlecart/                         # Shopping cart module
```

## Default Data

The application initializes with three default roles:

- ADMIN
- USER
- MARKETING

## API Endpoints

- **Home:** `/`
- **Users:** `/users`
- **Products:** `/products`
- **Brands:** `/brands`
- **Categories:** `/categories`

## Configuration Profiles

- **default** - Uses MySQL database (production)
- **dev** - Uses H2 in-memory database (development)

### Images Screen shot

Home Page

![Home Page](img/home.png "Home Page")

Add New User

![Add New User](img/user-add.png "Add New User")

List of Users

![List of Users](img/user-list.png "List of Users")

Add New Product

![Add New Product](img/product-add.png "Add New Product")

List of Product

![List of Product](img/product-list.png "List of Product")

Add New Category

![Add New Category](img/category-add.png "Add New Category")

Add New Brand

![Add New Brand](img/brand-add.png "Add New Brand")
