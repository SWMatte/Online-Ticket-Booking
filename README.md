# Online-Ticket-Booking
exercise of: Online-Ticket-Booking take this exercise from : https://www.java67.com/2022/12/10-projects-ideas-to-learn-spring-boot.html
# installation 
I have created a Spring project initialized using Spring Initializr.
Dependencies used: Spring JPA, Spring Web, MySQL Driver.Framework: Hibernate.

Make sure you have set up the configuration in the application.properties file to access your database.
After that, clone the repository from the website or using the following command in your specific folder:
git clone https://github.com/SWMatte/Online-Ticket-Booking.git
This will clone the repository into your local directory.

# Technologies Used
Java-Spring-Hibernate-MySQL
## some modified are been implemented in this project
     - I used Postman to make and test the API calls. I have attached the collection inside the repository.

### how this application work?

The purpose of this application is to allow end-users to purchase tickets for specific movies, displaying the purchased ticket with all the associated details, including Film, Cinema, Cost, and Customer information. The application also supports CRUD operations (Create, Read, Update, Delete) on various entities present within the application.Security ensures that these operations can only be performed when the user is logged in and their data is present in the database. Furthermore, the only endpoint accessible without authorization is the ADD-client endpoint.

## Class Explanation:
### Ticket Entity:

- View all the tickets present in the database.
- Add a new ticket.
- Add a discounted ticket (discounts based on the customer level: student/senior/VIP).
- Remove a specific ticket or remove all purchased tickets.
## Customers Entity:
- Perform CRUD operations on customers' data.
## Movie Entity:
- Perform CRUD operations on movie data.
##Cinema Entity:
- Perform CRUD operations on cinema data.
- Add seating arrangements based on the predefined capacity of the cinema.

## Valuation Entity:
- Add a review for a specific movie if it has been purchased by the user.
- Retrieve all the reviews available.

##  Role:
- Add authority from each user in the application

This application allows users to interact with movie ticketing functionalities, managing customers, movies, cinemas, and valuations. The CRUD operations enable easy management of the entities, and the ability to purchase discounted tickets ensures a flexible and user-friendly experience for the users.

# Future Improvements
I would like to add functionalities such as security and role-based access control, distinguishing between admin and regular users to perform certain API calls. I am open to new suggestions.
I would like improve a front-end application using Angular.

# License
MIT License

Copyright (c) 2023 Matteo Peiretti (SWMatte)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
