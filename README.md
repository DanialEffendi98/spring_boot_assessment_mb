1. Create a Java SpringBoot Application.
- Used Spring Initializr (start.spring.io) to create the application with the following dependencies (and updated the Java version to 8 and Spring Boot version to 2.7.18),
 - Spring Web
 - Spring Data JPA
 - SpringBoot Dev Tools
 - MSSQL Driver

2. Project Structure is required for ease of maintainability and readability.
Project structure

src/main/java/com/example/assessment

---config
RestTemplateConfig.java

---controllers
ThirdPartyController.java
UserController.java

---dao
Users.java

---dao/repo
UsersRepo.java

---dto/request
RegisterRequest.java
UpdateUserRequest.java

---dto/response
GetSingleUserResponse.java
RegisterResponse.java
ThirdPartyResponse.java
UpdateUserResponse.java

---services
ThirdPartyService.java
UsersService.java

---services/impl
ThirdPartyServiceImpl.java
UsersServiceImpl.java

src/main/resources
application.properties

3. Explore api for Client (Example: to be test via Postman. Please provide the Postman Collection.)
- Created a Postman collection for testing all the APIs developed
 - GET - All users with pagination, Specific user, 3rd Party API (Cat Facts by Heroku)
 - POST - Insert new user, Update user information

4. Each api required to log REQUEST & RESPONSE info into logs file.
- Configured logs in properties file named assessment.log

5. Your project able connect to database, preferred with MSSQL database (Using Local Machine DB, DB name: TESTDB).
- @transactional is required implement in the project. (For http Methos: INSERT, UPDATE, GET method)
- Created APIs based on no.3

6. Explore 1 GET method api with Pagination (Each Page 10 records)
- Created API to get all users with pagination (default pageNo = 0, pageSize = 10)

7. Explore an api which will nested calling another api from 3rd party.
Example: Postman/Client > Your API Endpoint > calling another api
- Created API endpoint -> http://localhost:8080/api/third-party/cat-facts that calls another 3rd party API -> https://cat-fact.herokuapp.com/facts/


Provided as well are the Postman Request collection and the SQL query for table creation and sample records.
- DB - MS SQL 
- DB_NAME - TESTDB
- Username - user
- Password - pass123