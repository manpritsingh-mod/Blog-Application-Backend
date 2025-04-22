# 📝 Blog Application Backend

This is the backend of a full-stack Blog Application built using **Spring Boot**.

It provides secure REST APIs for user registration, login, and blog CRUD operations. The backend is designed to work seamlessly with a frontend built in React.

## 🚀 Features

- ✅ User registration and login using email and password
- 🔐 Authentication using **Spring Security** with HttpSession
- ✍️ Authenticated users can create, edit, and delete their own blogs
- 📖 Public blog listing and blog detail pages (no login required)
- 📄 Pagination support on blog listing
- ❌ Users cannot edit/delete others' blogs
- 💾 Blogs and users stored in a **MySQL** database

## 🧰 Tech Stack

### 🧠 Backend
- Java 17+
- Spring Boot
- Spring Framework
- Hibernate
- JPA
- JDBC
- Maven

### 🛠️ Dependencies
- Spring Web
- Spring Boot DevTools
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL Driver
- Validation (javax.validation)
- Lombok

### 🧪 Tools
- MySQL
- Postman (for API testing)

## 🔑 API Endpoints

### Auth & User
- `POST /register` - Register a new user
- `POST /login` - Login user (form-based, sets session via HttpOnly cookie)
- `GET /account` - Get currently logged-in user info

### Blogs
- `GET /blogs` - Get all blogs (with pagination)
- `GET /blogs/{id}` - Get single blog by ID
- `POST /blogs` - Create a new blog (requires login)
- `PUT /blogs/{id}` - Update a blog (only by author)
- `DELETE /blogs/{id}` - Delete a blog (only by author)

## 📦 How to Run

> Make sure you have **MySQL**, **Java 17+**, and **Maven** installed

### 1. Clone the repository
```bash
git clone https://github.com/manpritsingh-mod/Blog-Application-Backend.git
cd Blog-Application-Backend
```

