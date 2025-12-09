# College Management System - Java Full Stack (Spring Boot + Thymeleaf)

## Overview
This is a minimal full-stack Java project built with Spring Boot, Thymeleaf, Spring Data JPA and H2 database.
It demonstrates core modules: Authentication (simple), Students CRUD, Notices, Dashboard.
The app uses server-rendered Thymeleaf pages (pure Java stack).

## What's included
- Spring Boot backend (controllers, entities, repositories)
- Thymeleaf templates for UI
- H2 file-based DB (located at ./data/cmsdb.*)
- Pre-created admin user:
  - username: admin
  - password: admin123

## How to run (Development)
1. Ensure you have Java 11+ and Maven installed.
2. Unzip the project and open a terminal in `college-management-system` folder.
3. Run: `mvn spring-boot:run`
4. Open browser: http://localhost:8080
5. Login with admin/admin123
6. Access H2 console: http://localhost:8080/h2-console
   - JDBC URL: jdbc:h2:file:./data/cmsdb
   - User: sa
   - Password: (leave blank)

## Switching to MySQL (Optional)
1. Add MySQL connector dependency in `pom.xml`.
2. Update `src/main/resources/application.properties`:
   spring.datasource.url=jdbc:mysql://localhost:3306/cmsdb
   spring.datasource.username=YOUR_USER
   spring.datasource.password=YOUR_PASS
   spring.jpa.hibernate.ddl-auto=update
3. Create DB `cmsdb` in MySQL.
4. Restart app.

## Project Structure (key files)
- src/main/java/com/cms/Application.java
- src/main/java/com/cms/controller/* (AuthController, HomeController, StudentController, NoticeController)
- src/main/java/com/cms/model/* (User, Student, Faculty, Course, Attendance, Marks, Notice, Fee)
- src/main/java/com/cms/repository/* (Jpa repositories)
- src/main/resources/templates/* (Thymeleaf views)
- src/main/resources/static/css/style.css
- src/main/resources/application.properties
- src/main/resources/data.sql (initial data)

## Development Phases & Steps (Detailed)

### Phase 1 - Setup (Completed in project)
- Initialize Spring Boot project with Thymeleaf, JPA, H2.
- Setup basic folder structure.
- Add `application.properties` for DB and server config.

### Phase 2 - Core Modules (Included)
- Authentication (simple session-based):
  - Login page, session creation, logout.
- Student Management:
  - List/Add/Edit/Delete students with Thymeleaf views.
- Notice Board:
  - Add/list notices, show on dashboard.
- Dashboard:
  - Shows user info and recent notices.

### Phase 3 - Extended Modules (Guidance)
- Faculty Management:
  - Implement Faculty entity, repository, controller, templates (similar to Student).
- Course Management:
  - Course entity + assign faculty.
- Attendance:
  - Attendance entity and controller to mark/view.
- Marks:
  - Marks entity and upload/view marks.
- Fees:
  - Fee entity and payment recording.
- Reports & CSV export:
  - Implement endpoints to export student lists, attendance, marks.

### Phase 4 - Testing & Deployment
- Manual testing via UI.
- Use Postman for API testing.
- Packaging: `mvn clean package` produces executable jar.
- Deploy to Heroku/Render/AWS:
  - Provide DB credentials and adjust `application.properties`.

## Notes & Next Steps
- For production, integrate Spring Security and BCrypt-hashed passwords.
- Add role-based access control: ADMIN/FACULTY/STUDENT.
- Add pagination and search for lists.
- Replace H2 with MySQL/Postgres for persistence.
- Add REST APIs and a separate React frontend if desired.

## Contact
If you want, I can:
- Expand the project with Faculty, Course, Attendance, Marks, Fees modules fully implemented.
- Add REST API + React frontend.
- Add unit tests, Dockerfile and CI pipeline.

