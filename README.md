# Description
This is a simulation of how movie cinema works. 
The aim of the project is to show skills in creating Java-applications with combined usage of Spring and Hibernate.
You can add a ticket with the chosen movie and movie session to the shopping cart, make an order. 
Also, you can get all information about completed orders, available movie sessions, etc.

# Technologies
- Java 11
- MySQL
- Hibernate
- Spring
- Tomcat
- Postman

# Install

- Fork and copy this project
- Install MySQL
- Change data in db.properties file to connect db
- Install Tomcat and run the server

# You can use next endpoints
- GET - /cinema-halls, /movies, /movie-sessions/available, /movie-sessions/id - USER and ADMIN,
- GET - /users/by-email?email - ADMIN,
- GET - /orders, /shopping-carts/by-user - USER;
- POST - /register, /login- unauthorized,
- POST - /cinema-halls, /movies, /movie-sessions - ADMIN,
- POST - /orders/complete - USER role;
- PUT - /movie-sessions/id - ADMIN,
- PUT - /shopping-carts/movie-sessions?movieSessionId - USER;
- DELETE - /movie-sessions/id - ADMIN.
