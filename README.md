# Todo API 📝

RESTful API for task management built with Java and Spring Boot.

## Technologies
- Java 21
- Spring Boot 3.5
- Spring Data JPA
- H2 Database
- Lombok
- Maven

## How to run
```bash
./mvnw spring-boot:run
```

Access: `http://localhost:8080`

## Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | /tasks | List all tasks |
| GET | /tasks/{id} | Get task by ID |
| POST | /tasks | Create task |
| PUT | /tasks/{id} | Update task |
| DELETE | /tasks/{id} | Delete task |

## Request example (POST /tasks)
```json
{
    "title": "My first task",
    "description": "Testing the API"
}
```

## Author
Matheus Shoiti Tokunaga  
[GitHub](https://github.com/shoiti26x) • [LinkedIn](www.linkedin.com/in/shoiti-tokunaga)
