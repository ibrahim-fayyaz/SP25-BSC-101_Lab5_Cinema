# SP25-BSC-101_Lab5_Cinema

## Overview
This project is a **City-Wide Cinema Management System** implemented in Java.  
It allows management of cities, cinemas, screens, and seats, including booking, cancellation, and seat availability tracking.

## Features
- Manage multiple cities and cinemas  
- Support for different seat types: Regular, Premium, VIP, Recliner  
- Book and cancel seats by ID or coordinates  
- Display seat layouts (compact and detailed)  
- Search for first available VIP seat  
- Reports for total and available seats  

## Project Structure
- `Seat.java` – Represents individual seats  
- `Screen.java` – Represents a cinema screen with rows of seats  
- `Cinema.java` – Represents a cinema with multiple screens  
- `CityCinema.java` – Represents all cinemas in a city  
- `SeatDemo.java` – Demonstrates `Seat` class functionality  
- `CinemaDemo.java` – Demonstrates full system workflow  

## How to Run
1. Compile all Java files:  
```bash
javac *.java

