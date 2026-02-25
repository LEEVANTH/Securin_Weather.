🌦 Weather REST API – Spring Boot

A Spring Boot REST API to manage and retrieve weather data.
This project demonstrates RESTful services, filtering, sorting, and database integration using Spring Boot.

📌 Features

Retrieve all weather data

Sort weather records dynamically

Filter weather by condition

Filter weather by temperature

Clean REST API structure

Easy to test using Postman

🛠️ Technologies Used

Java

Spring Boot

Spring Web

Spring Data JPA

Hibernate

MySQL / H2 Database

Maven

📁 Project Structure
src/main/java
 └── com.kce.weather
      ├── controller
      │    └── WeatherController.java
      ├── service
      │    └── WeatherService.java
      ├── repository
      │    └── WeatherRepository.java
      └── entity
           └── WeatherData.java
🌐 Base URL
http://localhost:8080/weather
🔗 API Endpoints
1️⃣ Get All Weather Data

Endpoint

GET /weather

Description
Returns all weather records stored in the database.

Example

http://localhost:8080/weather
2️⃣ Get Sorted Weather Data

Endpoint

GET /weather?sortBy={field}&direction={asc|desc}

Query Parameters

Parameter	Required	Description
sortBy	No	Field name (temperature, city, condition)
direction	No	Sort order: asc or desc (default: asc)

Examples

/weather?sortBy=temperature
/weather?sortBy=city&direction=desc
3️⃣ Get Weather by Condition

Endpoint

GET /weather/condition?conds={condition}

Description
Returns weather records matching the given condition.

Example

/weather/condition?conds=Sunny
4️⃣ Get Weather Above a Temperature

Endpoint

GET /weather/temp?temp={value}

Description
Fetches weather records where temperature is greater than the specified value.

Example

/weather/temp?temp=30
📦 Sample Response
[
  {
    "id": 1,
    "city": "Chennai",
    "temperature": 34.5,
    "condition": "Sunny"
  },
  {
    "id": 2,
    "city": "Coimbatore",
    "temperature": 28.0,
    "condition": "Cloudy"
  }
]
▶️ How to Run the Project
Step 1: Clone the Repository
git clone https://github.com/your-username/weather-api.git
Step 2: Open the Project

Open in IntelliJ IDEA or Eclipse

Make sure Java 17+ is installed

Step 3: Configure Database

Edit src/main/resources/application.properties

Example (MySQL):

spring.datasource.url=jdbc:mysql://localhost:3306/weatherdb
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Step 4: Run the Application
mvn spring-boot:run
Step 5: Test APIs

Open browser or Postman:

http://localhost:8080/weather
🧪 Testing Tools

Postman

Browser (GET requests)

cURL

🚀 Future Enhancements

Pagination & searching

Exception handling

Validation using @Valid

Swagger API documentation

Authentication (JWT)

👨‍💻 Author

Leevanth P
Java Backend Developer
