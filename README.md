# Quickstart Guide   

This guide will walk you through the steps to set up and run the **Student CRM with Camunda** project.

## Technology
In this project the following was used:
- **Docker** and **Docker Compose**
- **Java 21**
- **Gradle**


---

## 1. Run Docker Compose

In the backend directory, run the following command to start the database using Docker Compose:

```bash
docker-compose up -d
```

## 2. Build and Run the Application

Once the database is up and running, you can proceed to build and start the Spring Boot application by running:

```bash
./gradlew bootRun
```

Your application should now be running and accessible at: http://localhost:8080

## 3. User Accounts

| **Role**               | **Username** | **Group**             | **Password** |
|------------------------|--------------|-----------------------|--------------|
| Student                | ca           | students              | demo         |
| Examination Office    | ba           | examOffice    | demo         |
| Technical Service     | rt           | technicalService    | demo         |
| Admin                  | demo         | -                     | demo         |


## 2. Start a Process

Currently there is only the "Exam Registration" available.

1. Log in to Camunda Tasklist as the student (ca):
   - Go to the Camunda web interface at: http://localhost:8080/camunda](http://localhost:8080/camunda/app/tasklist
   - Start the process "exam-registration" in start process tab
   - use Email "cassian@mail.com" and select courses you want to enroll and hit start (Course C does not exist, you can select it to test other sequence flows)
   - If you are past the deadline the process will stop. You will get a User Task where you can decide to cancel or justify 

2. Log in to Tasklist as examination office member (ba) or technical service (rt)
   - You will get a user task where you can decide to accept or decline the justification (depends on justification type, technical or personal reason)
   - accepting results in successfuly assigning the courses to student "ca"
  
3. You can check the assignment in the DB in table "student_course" and get an confirmation email, if you start the process with an course that is already enrolled or doesnt exist the process will stop and you get a information mail.

## 4. Database

| Key        | Value                                      |
|------------|--------------------------------------------|
| `url`      | `jdbc:postgresql://localhost:5432/postgres` |
| `username` | `postgres`                                  |
| `password` | `secret`                                    |



