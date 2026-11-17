# MicroCourse Backend API

## UML Class Diagram

![Class Diagram](../project%20images/MicroCourse_UML_Diagram.png)

## API Overview

**Version:** 1.0

**Last Updated:** October 23, 2026

**Base URL:**

- Local: `http://localhost:8080/api`
- Production: `https://team-20-project.onrender.com/api`

## Profile and discovery

| Method | Path | Purpose | Response code | Error codes | User story | Implementer |
|---|---|---|---|---|---|---|
| `POST` | `/api/instructors` | Create an instructor profile | `201 Created` | `400, 500` | US-5 | Kelly |
| `GET` | `/api/instructors` | List instructor profiles | `200 OK` | `500` | US-5 | Kelly |
| `GET` | `/api/instructors/{id}` | Read an instructor profile | `200 OK` | `404, 500` | US-5 | Kelly |
| `PUT` | `/api/instructors/{id}` | Update an instructor profile | `200 OK` | `400, 404, 500` | US-5 | Kelly |
| `DELETE` | `/api/instructors/{id}` | Delete an instructor profile | `204 No Content` | `404, 500` | US-5 | Kelly |

### Example Instructor Request

```http
POST /api/instructors
Content-Type: application/json

{
  "name": "Bob White",
  "qualifications": "Bachelor's Degree in Computer Science",
  "areasOfExpertise": "Java, C++",
  "profileDescription": "Helping people learn at their own pace while being a full-time professor at a local college."
}
```

### Example Instructor Update Request

```http
PUT /api/instructors/1
Content-Type: application/json

{
  "name": "Bob White",
  "qualifications": "Master's Degree in Computer Science",
  "areasOfExpertise": "Java, C++, Python",
  "profileDescription": "Helping people learn programming at their own pace."
}
```
## Customer Account Management

| Method | Path | Purpose | Response Code | Error Codes | User Story | Implementer |
|----------|----------|----------|----------|----------|----------|----------|
| `POST` | `/api/customers` | Register a new customer account | `201 Created` | `400, 409, 500` | US-1 | Ulises |
| `GET` | `/api/customers/{id}` | View a customer profile | `200 OK` | `404, 500` | US-1 | Ulises |
| `GET` | `/api/customers/email/{email}` | Search customer by email | `200 OK` | `404, 500` | US-1 | Ulises |
| `GET` | `/api/customers/username/{userName}` | Search customer by username | `200 OK` | `404, 500` | US-1 | Ulises |
| `PUT` | `/api/customers/{id}` | Update customer profile | `200 OK` | `400, 404, 409, 500` | US-1 | Ulises |
| `DELETE` | `/api/customers/{id}` | Delete customer account | `204 No Content` | `404, 500` | US-1 | Ulises |

### Example Customer Registration Request

```http
POST /api/customers
Content-Type: application/json

{
  "userName": "jdoe123",
  "firstName": "John",
  "lastName": "Doe",
  "email": "jdoe@email.com",
  "phoneNumber": "555-123-4567",
  "password": "password123",
  "interests": [
    "Programming",
    "Artificial Intelligence",
    "Data Science"
  ]
}
```
### Example Customer Update Request

```http
PUT /api/customers/1
Content-Type: application/json

{
  "userName": "jdoe123",
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@email.com",
  "phoneNumber": "919-555-1234",
  "password": "password123",
  "interests": [
    "Programming",
    "Cybersecurity",
    "Cloud Computing"
  ]
}
```

### Example Customer Response

```json
{
  "id": 1,
  "userName": "jdoe123",
  "firstName": "John",
  "lastName": "Doe",
  "email": "jdoe@email.com",
  "phoneNumber": "555-123-4567",
  "interests": [
    "Programming",
    "Artificial Intelligence",
    "Data Science"
  ]
}
```

## Courses and learning content

| Method | Path | Purpose | Response code | Error codes | User story | Implementer |
|---|---|---|---|---|---|---|
| `POST` | `/api/courses` | Create and publish a course | `201 Created` | `400, 500` | US-6 | Kelly |
| `GET` | `/api/courses` | List courses | `200 OK` | `500` | US-6 | Kelly |
| `GET` | `/api/courses/{id}` | Read a course | `200 OK` | `404, 500` | US-6 | Kelly |
| `PUT` | `/api/courses/{id}` | Update course information | `200 OK` | `400, 404, 500` | US-8 | Kelly |
| `DELETE` | `/api/courses/{id}` | Delete a course | `204 No Content` | `404, 500` | US-8 | Kelly |
| `POST` | `/api/lessons` | Create a lesson | `201 Created` | `400, 500` | US-6/8 | Kelly |
| `GET` | `/api/lessons` | List lessons | `200 OK` | `500` | US-6/8 | Kelly |
| `GET` | `/api/lessons/{id}` | Read a lesson | `200 OK` | `404, 500` | US-6/8 | Kelly |
| `PUT` | `/api/lessons/{id}` | Update a lesson | `200 OK` | `400, 404, 500` | US-6/8 | Kelly |
| `DELETE` | `/api/lessons/{id}` | Delete a lesson | `204 No Content` | `404, 500` | US-6/8 | Kelly |
| `POST` | `/api/resources` | Create a learning resource | `201 Created` | `400, 500` | US-6/8 | Kelly |
| `GET` | `/api/resources` | List learning resources | `200 OK` | `500` | US-6/8 | Kelly |
| `GET` | `/api/resources/{id}` | Read a learning resource | `200 OK` | `404, 500` | US-6/8 | Kelly |
| `PUT` | `/api/resources/{id}` | Update a learning resource | `200 OK` | `400, 404, 500` | US-6/8 | Kelly |
| `DELETE` | `/api/resources/{id}` | Delete a learning resource | `204 No Content` | `404, 500` | US-6/8 | Kelly |


### Example Course Request

```http
POST /api/courses
Content-Type: application/json

{
  "title": "Introduction to Java",
  "description": "Learn Java programming fundamentals.",
  "topic": "Programming",
  "price": 49.99,
  "durationInHours": 10,
  "instructor": {
    "id": 1
  }
}
```

### Example Course Update Request

```http
PUT /api/courses/1
Content-Type: application/json

{
  "title": "Introduction to Java - Updated",
  "description": "Learn Java programming fundamentals and practice with examples.",
  "topic": "Programming",
  "price": 59.99,
  "durationInHours": 12,
  "instructor": {
    "id": 1
  }
}
```

### Example Lesson Request

```http
POST /api/lessons
Content-Type: application/json

{
  "title": "Java Variables",
  "description": "Learn about variables and data types.",
  "lessonOrder": 1,
  "course": {
    "id": 1
  }
}
```

### Example Lesson Update Request

```http
PUT /api/lessons/1
Content-Type: application/json

{
  "title": "Java Variables - Updated",
  "description": "Learn about variables, data types, and assigning values.",
  "lessonOrder": 1,
  "course": {
    "id": 1
  }
}
```

### Example Resource Update Request

```http
PUT /api/resources/1
Content-Type: application/json

{
  "title": "Updated Java Variables Reference",
  "resourceType": "DOCUMENT",
  "url": "https://example.com/java-variables",
  "lesson": {
    "id": 1
  }
}
```

## Enrollment and course availability

| Method | Path | Purpose | Response code | Error codes | User story | Implementer |
|---|---|---|---|---|---|---|
| `POST` | `/api/course-enrollments` | Create an enrollment record | `201 Created` | `400, 500` | US-9 | Kelly |
| `GET` | `/api/course-enrollments` | List enrollment records | `200 OK` | `500` | US-9 | Kelly |
| `GET` | `/api/course-enrollments/{id}` | Read an enrollment record | `200 OK` | `404, 500` | US-9 | Kelly |
| `GET` | `/api/course-enrollments/course/{courseId}` | List enrollments for a course | `200 OK` | `500` | US-9 | Kelly |
| `GET` | `/api/course-enrollments/customer/{customerId}` | List enrollments for a customer | `200 OK` | `500` | US-9 | Kelly |
| `PUT` | `/api/course-enrollments/{id}` | Update an enrollment status | `200 OK` | `400, 404, 500` | US-9 | Kelly |
| `DELETE` | `/api/course-enrollments/{id}` | Delete an enrollment record | `204 No Content` | `404, 500` | US-9 | Kelly |

### Example Enrollment Request

```http
POST /api/course-enrollments
Content-Type: application/json

{
  "status": "ENROLLED",
  "customerId": 1,
  "course": {
    "id": 1
  }
}
```

### Example Enrollment Update Request

```http
PUT /api/course-enrollments/1
Content-Type: application/json

{
  "status": "COMPLETED",
  "customerId": 1,
  "course": {
    "id": 1
  }
}
```

## Sessions and reviews

| Method | Path | Purpose | Response code | Error codes | User story | Implementer |
|---|---|---|---|---|---|---|
| `POST` | `/api/reviews` | Create a review | `201 Created` | `400, 500` | US-7 | Kelly |
| `GET` | `/api/reviews` | List reviews | `200 OK` | `500` | US-7 | Kelly |
| `GET` | `/api/reviews/{id}` | Read a review | `200 OK` | `404, 500` | US-7 | Kelly |
| `GET` | `/api/reviews/instructor/{instructorId}` | List reviews for an instructor | `200 OK` | `500` | US-7 | Kelly |
| `PUT` | `/api/reviews/{id}` | Update a review | `200 OK` | `400, 404, 500` | US-7 | Kelly |
| `PUT` | `/api/reviews/{id}/reply` | Reply to a review | `200 OK` | `400, 404, 500` | US-7 | Kelly |
| `DELETE` | `/api/reviews/{id}` | Delete a review | `204 No Content` | `404, 500` | US-7 | Kelly |

### Example Review Reply Request

```http
PUT /api/reviews/1/reply
Content-Type: application/json

{
  "reply": "Thank you for your feedback!"
}
```

### Example Review Update Request

```http
PUT /api/reviews/1
Content-Type: application/json

{
  "rating": 4,
  "comment": "The course was helpful and easy to follow.",
  "reply": "",
  "customerId": 1,
  "instructor": {
    "id": 1
  }
}
```

## Error handling

| Status code | Meaning |
|---|---|
| `200 OK` | The request succeeded. |
| `201 Created` | A resource was created successfully. |
| `204 No Content` | The request succeeded without a response body. |
| `400 Bad Request` | The request contains invalid input, if validation or request handling returns this status. |
| `404 Not Found` | The requested resource was not found, if the endpoint handles missing resources with this status. |
| `409 Conflict` | The request conflicts with the current state of a resource, if supported by the endpoint. |
| `500 Internal Server Error` | An unexpected server or database error occurred. |

## Deployment
The API is deployed on Render and uses a PostgreSQL database hosted on Neon.

### Cold Starts
This project uses a free Render web service. Free services may sleep after a period of inactivity. The first request after the service has been idle can take up to a minute while the service starts again.