# QuizApp

## Data Seeding

**The Data is pre-seeded with**
1. 3 Questions with corresponding correct answers and options
2. 1 User with the username testUser

## User Management
1. Users are uniquely identified by their username field
2. A custom method findByUsername is defined in the UserRepository to retrieve users.

## Quiz Functionality
1.The quiz starts with a POST request to /api/quiz/start that provides a starting message but doesn't create a session .

## Dependencies
1. spring-boot-starter-data-jpa for database interactions
2. spring-boot-starter-web for REST API Functionality
3. H2 Database for in-memory data persistence.

# Instructions

1. Clone the GitHub repository [QuizApp](https://github.com/techbrothers3/QuizApp)
2. Run `mvn clean install`
3. Run `mvn spring-boot:run`
4. This will start the springboot server

## API's
**Now you can run following API's to test the application**
### Start Session API
`curl --location --request POST 'localhost:8080/api/quiz/start'`
### Get Statistics
`curl --location --request GET 'localhost:8080/api/quiz/stats?username=testUser'`
### Submit Answer
`curl --location --request POST 'localhost:8080/api/quiz/submit?questionId=1&answer=J.K Rowling&username=testUser'`
### Get Question
`curl --location --request GET 'localhost:8080/api/quiz/question'`