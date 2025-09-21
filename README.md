# abstract_factory_patterns
# 🚗 Car Factory Demo (Factory Method & Abstract Factory Patterns)

## 📌 Overview
This project demonstrates the **Factory Method** and **Abstract Factory** design patterns in Java.  
It uses the example of creating different types of **Cars** (Sedan, SUV) and adapting them to different **regions** (Europe, USA).  

The implementation follows **Clean Code** and **Object-Oriented Programming (OOP) principles**, ensuring:
- **Encapsulation**: Each class has one clear responsibility.  
- **Abstraction**: Clients depend on interfaces, not implementations.  
- **Polymorphism**: Different car types and regional variants can be used interchangeably.  
- **Open/Closed Principle (OCP)**: New car types or regions can be added without modifying existing code.  
- **Dependency Inversion Principle (DIP)**: High-level modules depend on abstractions, not concrete classes.  

---

## 🏗️ Project Structure
All classes are inside a single file for simplicity:


### Classes
- **Car (interface)** → common behavior for all cars.  
- **Sedan, SUV** → concrete car types.  
- **CarFactory (interface)** → Factory Method creator.  
- **SedanFactory, SUVFactory** → concrete car factories.  
- **RegionalCarFactory (interface)** → Abstract Factory creator.  
- **EuropeCarFactory, USACarFactory** → concrete regional factories.  
- **CarClient** → client that uses factories without knowing concrete classes.  
- **Application** → wires objects together (Dependency Injection).  
- **Main** → program entry point (only starts Application).  

---

## ⚙️ How It Works
1. **Factory Method Pattern**  
   - `SedanFactory` and `SUVFactory` create individual car objects.  

2. **Abstract Factory Pattern**  
   - `EuropeCarFactory` and `USACarFactory` create **families of cars** (Sedan + SUV) adapted to regional standards.  

3. **CarClient**  
   - Uses both patterns to build cars without knowing their concrete classes.  

4. **Application**  
   - Handles wiring of objects.  

5. **Main**  
   - Only runs the application (no object creation in `main()`).  

---

## ▶️ How to Run
1. Save the code below in a file called `Main.java`.  

2. Compile the program:
   ```bash
   javac Main.java
