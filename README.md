# Description
CinemaApp is an application to manage tickets bought on the occasion of a cinema session by a user. 
An app can be used to organize the interactions between the customer and selling department, a user has an opportunity to choose available sessions, purchase tickets, make an order, view order history, login and register.

## Guest (unauthorized and non registered) can do the following:
- register
- login
### Authenticated user:
- has the same capabilities as the guest + capability to
- view all data about movie sessions, movies and cinema halls
- add tickets to shopping cart
- view order history
- complete orders
- check current shopping cart
### Admin:
- has the same capabilities of user, additionally can
- add new movie sessions/cinema halls
- manage movies, movies sessions and cinema halls
- manage schedule
- look info about users

# Technologies
- Java 11
- MySQL
- Hibernate
- Spring
- Tomcat
- JSON

# Configuration

- Clone this project into your local folder and open the project in an IDE.
- Configure a Local Tomcat server: deployment - war_exploded, context address - "/"
- Insert your own MySQL username and password in db.properties and setup new connection with:
- Run a project
- You can log in as Admin: (name: "admin@gmail.com", password:"12345")


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
