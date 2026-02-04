# 📝 Blog Application (Spring Boot)

A secure and scalable **Blog Application** developed using **latest Spring Boot**.  
This project focuses heavily on **modern Spring Security**, **JWT authentication**, and **clean backend architecture**.

---

## 🔐 Security Implementation (Most Important Section)

Security is the core foundation of this application.  
The project follows **stateless authentication** using **JWT (JSON Web Token)** and implements **industry-standard security practices**.

---

### 🚀 Security Features Implemented

#### ✅ JWT (JSON Web Token) Authentication
- Stateless authentication using JWT
- JWT token is generated after successful login
- Client must send token with every secured API request
- Token is passed via HTTP header:
  ```http
  Authorization: Bearer <JWT_TOKEN>
  ```

#### ✅ Password Encryption (PasswordEncoder)
- Passwords are **never stored in plain text**
- Implemented `BCryptPasswordEncoder`
- Passwords are hashed before saving into the database
- During login, hashed password is validated securely

#### ✅ Spring Security (Latest Version)
- Implemented using **latest Spring Boot & Spring Security**
- Uses **SecurityFilterChain** instead of deprecated `WebSecurityConfigurerAdapter`
- Custom JWT authentication filter is registered before `UsernamePasswordAuthenticationFilter`

#### ✅ Role-Based Authorization
- Roles supported:
  - `ROLE_ADMIN`
  - `ROLE_USER`
- API-level security using annotations:
  ```java
  @PreAuthorize("hasRole('ADMIN')")
  ```
- Admin-only APIs are fully protected

---

### 🔄 Difference From YouTube Tutorial Code

| Feature | YouTube Tutorial | My Implementation |
|------|------------------|------------------|
| Login Field | Email | **Username** |
| Spring Boot Version | Older Version | **Latest Spring Boot** |
| Security Configuration | Deprecated Style | **SecurityFilterChain** |
| JWT Setup | Basic | **Updated & Optimized** |

📌 **Note:**  
The YouTuber used **email for authentication**,  
but **I changed the logic to authenticate users using `username` instead**.

---

### ⚠️ Important JWT Dependency Note

If JWT imports **do not work**, make sure **ALL THREE JWT dependencies** are added in `pom.xml`:

```xml
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.5</version>
</dependency>

<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.11.5</version>
    <scope>runtime</scope>
</dependency>

<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>0.11.5</version>
    <scope>runtime</scope>
</dependency>
```

⚠️ **Missing even one dependency will cause JWT imports to fail.**

---

## ✨ Application Features

### 👤 User Management
- User registration
- Login using **username & password**
- Secure password storage using BCrypt
- Role assignment (ADMIN / USER)

### 📝 Blog Post Management
- Create blog posts
- Update blog posts
- Delete blog posts
- Fetch single or all blog posts

### 🗂️ Category Management
- Create categories
- Update categories
- Delete categories
- Fetch all categories

### 💬 Comment Management
- Add comments to blog posts
- Delete comments
- Fetch comments by post

### 📄 Pagination & Sorting
- Pagination support for blog posts
- Sorting by title, date, etc.

---

## 🛠️ Tech Stack

- **Java**
- **Spring Boot (Latest)**
- **Spring Security**
- **JWT Authentication**
- **JPA / Hibernate**
- **MySQL**
- **Maven**

---

## ▶️ How To Run The Project

1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```

2. Configure database details in `application.properties`

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Test APIs using Postman or Swagger

---

## 👨‍💻 Author

**Rahul Kumar**  
Backend Developer 
Backend Developer | Java | Spring Boot | Spring Security

---

⭐ If you find this project helpful, feel free to star the repository!
