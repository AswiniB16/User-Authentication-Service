# **Book Exchange Platform**

---
Book Exchange Service is a microservice designed to handle the user register, login, password reset 
and logout.It also provides CRUD operations for book listing with optional filters, add books edit books and delete book.

## Overview

---
The Book Exchange Platform is designed to facilitate book exchange for book lovers in a larger scale.
It includes different core service like:
- UserServices:        Manges user registration, login, password reset
- BookListing Service: Manages search books with filter options
- ManageBookService:   Manages add, edit and deletion of books

## Technologies

---
- Java 18
- SpringBoot for microservice architecture
- PostgreSQL as the primary database

## How to Set Up

---
### Tools Required

- Any Java IDE
- Pgadmin
- JDK
- Postman

### Steps

1. Import as a gradle project into the Java IDE of your preference.
2. For building the gradle project
   ```` 
   gradlew clean build
   ````