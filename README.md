# CRUD_Project_1
Hotel Management System App (Console Based)
 A comprehensive Hotel Management System built using Java and Maven. This application facilitates efficient management of hotel operations, including room bookings, customer information, and more.

 ✅ Core Java (OOP, JDBC, Exception Handling)

 ✅ PostgreSQL Database

 ✅ Maven Project Structure

📂 Project Structure Hotel-Management-System-app/

└── src/
    └── main/
        ├── java/
        │   └── org.example/
        │       ├── Main.java
        │       ├── dbconnect.java
        │       ├── guest.java
        │       ├── reservation.java
        │       ├── rooms.java
        │       └──
        └── resources
        └── db.properties
        └──pom.xml
        └──README.mdn



🗃️ Database Setup (PostgreSQL)
 Rooms
create table rooms (
  id SERIAL primary key,
  room_number varchar(10) UNIQUE not null,
  type varchar(50) not null,
  price numeric(10,2) not null,
  isavailable boolean not null
);

 Guests
create table guests (
  id SERIAL primary key,
  name varchar(100),
  email VARCHAR(100) UNIQUE,
 );

  Reservations
 create table reservations (
   id SERIAL primary key,
   room_id integer NOT NULL REFERENCES rooms(room_id),
   guest_id integer NOT NULL REFERENCES guests(id),
   check_in Date not null,
   check_out Date not null,
 );


⚙️ Configuration Edit the PostgreSQL credentials in DBConnection.java:

String url = "jdbc:postgresql://localhost:5432/mydb";
String user = "postgres";
String password = "asmita123";


🚀 How to Run Clone the repo or copy the project folder.

Set up PostgreSQL and create the required tables.

Open the project in Eclipse, IntelliJ, or any IDE with Maven support.

Run Main.java to start the app.



🧾 Features

CRUD for bookings: create, view, book reservations

Room availability tracking, preventing double-bookings


 🧩 Contributers 
 
🧑‍💻 Author Made with 💡 by Asmita Jarhalli 
                      and 
‍💻 Author Made with 💡 by Shivani Gajul


