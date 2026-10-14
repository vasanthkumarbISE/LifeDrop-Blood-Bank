# 🩸 LifeDrop – Blood Bank Management System

A web-based Blood Bank Management System developed using Java, Spring Boot, and MySQL. The application helps manage donors, blood stock, blood groups, and blood bank information.

## 📌 Project Overview

LifeDrop is designed to simplify blood bank operations by organizing donor details and blood stock information in a centralized system.

## ✨ Features

- 📊 Dashboard for blood bank management
- 🩸 Blood stock management
- 🧪 Blood group information
- 👥 Donor management
- 📝 Donor registration
- 🔍 View registered donors
- 🌐 Web-based user interface
- 🗄️ MySQL database integration

## 🛠️ Technologies Used

- **Backend:** Java, Spring Boot, Spring MVC
- **Database:** MySQL
- **Database Operations:** Spring Data JPA
- **Frontend:** HTML, CSS, Thymeleaf (if configured)
- **Build Tool:** Maven

## 💻 Prerequisites

Install the following software:

1. Java JDK
2. MySQL Server
3. Maven or the Maven Wrapper included in the project
4. Git (optional)
5. Web browser

Verify the installations:

```bash
java -version
mvn -version
```

## 📥 Installation and Setup

### Step 1: Clone the Repository

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

Alternatively, download the ZIP file from GitHub and extract it.

### Step 2: Open the Project

Open Command Prompt or PowerShell and navigate to the project directory containing `pom.xml`.

```powershell
cd "C:\Users\Vasanth Kumar\Downloads\blood-bank\blood-bank"
```

Check the project files:

```powershell
dir
```

### Step 3: Configure the MySQL Database

Open MySQL Workbench or the MySQL command-line client.

Create the database if it does not already exist:

```sql
CREATE DATABASE blood_bank_db;
```

Use the database name configured in your application.

### Step 4: Configure Database Connection

Open `src/main/resources/application.properties` and check the following settings:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blood_bank_db
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Replace `YOUR_MYSQL_PASSWORD` with your MySQL password. Keep existing settings that your project requires, and do not upload real credentials to GitHub.

## ▶️ How to Run the Project

### Step 1: Open the Terminal

Navigate to the directory containing `pom.xml`.

### Step 2: Start the Application

Using Maven:

```bash
mvn spring-boot:run
```

Or, if the project includes the Maven Wrapper:

```powershell
.\mvnw.cmd spring-boot:run
```

Wait until Spring Boot starts successfully. Keep the terminal running.

### Step 3: Open the Application

Open your browser and visit:

- Home: http://localhost:8080/
- Register Donor: http://localhost:8080/register
- Donors: http://localhost:8080/donors
- About: http://localhost:8080/about

These URLs depend on the routes implemented in your controllers.

### Step 4: Stop the Application

Press `Ctrl + C` in the terminal.

## 📁 Project Structure

```text
blood-bank/
├── pom.xml
├── mvnw
├── mvnw.cmd
├── src/
│   └── main/
│       ├── java/
│       │   └── blood_bank/
│       │       ├── controller/
│       │       ├── entity/
│       │       ├── repository/
│       │       └── ...
│       └── resources/
│           ├── application.properties
│           └── templates/
└── README.md
```

The exact structure may vary depending on your implementation.

## 🗄️ Database Tables

The project database may contain tables such as:

- `donors` – stores donor information
- `blood_stock` – stores blood stock details
- `blood_requests` – stores blood requests

The actual tables and columns depend on your database schema and entity classes.

## 🐛 Troubleshooting

**MySQL connection error**
- Ensure MySQL Server is running.
- Verify the database name, username, password, and port.

**Maven command not recognized**
- Install Maven or use `mvnw.cmd` if available.

**Port 8080 already in use**
- Stop the other application using the port or configure a different port.

**Page not found**
- Verify the URL and controller mapping.
- Check the Spring Boot terminal for errors.

**Database tables are missing**
- Check the entity mappings and database configuration.
- Back up existing data before changing database settings.

## 🚀 Future Enhancements

- Blood availability search
- Blood request management
- Low-stock notifications
- Donor eligibility tracking
- Dashboard statistics
- Improved security and access control
- Cloud deployment

## 🎯 Project Objective

The objective of LifeDrop is to simplify blood bank information management through a web application while demonstrating practical skills in Java, Spring Boot, MySQL, and backend development.
