
# 📘 JDBC (Java Database Connectivity) – #Day1

---

## 1. Definition

* JDBC (Java Database Connectivity) is a **Java API** that allows Java programs to **connect with relational databases** (like MySQL, Oracle, PostgreSQL) and perform operations such as **insert, update, delete, and retrieve data**.
* It acts as a **bridge between Java applications and databases**.

---

## 2. **Components of JDBC**

1. **Driver**

   * A software component that translates JDBC calls into database-specific calls.
   * Example: MySQL Driver → `com.mysql.cj.jdbc.Driver`.

2. **DriverManager**

   * Manages a list of available drivers.
   * Responsible for establishing a connection between Java program and the database.
   * Method used: `DriverManager.getConnection(url, username, password)`.

3. **Connection**

   * Represents a session between Java program and the database.
   * Used to send SQL statements and manage transactions.

4. **Statement**

   * Used to send SQL queries (like SELECT, INSERT, UPDATE, DELETE) to the database.
   * Types:

     * `Statement` – for simple queries.
     * `PreparedStatement` – for parameterized queries (faster, safer).
     * `CallableStatement` – for calling stored procedures.

5. **ResultSet**

   * Represents the result of a SELECT query.
   * Works like a table with rows and columns that you can iterate through.
   * Example methods: `next()`, `getInt()`, `getString()`.

6. **SQLException**

   * Exception class that handles database access errors.
   * Example: wrong query, wrong column name, wrong credentials.

---

## 3. **Benefits of JDBC**

* **Database Independence** – Same code can work with multiple databases by just changing driver & URL.
* **Platform Independence** – Works on any OS that supports Java.
* **Ease of Use** – Provides simple methods to execute SQL queries.
* **Flexibility** – Supports different drivers and query types.
* **Security** – Provides authentication and secure connections.

---

## 4. **JDBC Architecture**

### 🔹 Two-Tier Architecture

* Java Application ↔ JDBC Driver ↔ Database.
* Used in small applications.

### 🔹 Three-Tier Architecture

* Java Application ↔ Application Server ↔ JDBC Driver ↔ Database.
* Used in large enterprise applications for better scalability and security.

### **Steps in JDBC Workflow**

1. Load driver.
2. Establish connection.
3. Create statement.
4. Execute query.
5. Process results.
6. Close connection.

---

## 5. **Types of JDBC Drivers**

1. **Type 1 – JDBC-ODBC Bridge Driver**

   * Translates JDBC calls into ODBC calls.
   * Platform-dependent, slow, deprecated.

2. **Type 2 – Native API Driver**

   * Uses vendor-specific libraries.
   * Faster, but platform-dependent.

3. **Type 3 – Network Protocol Driver**

   * Uses middleware server to connect.
   * Database independent, flexible.

4. **Type 4 – Thin Driver (Pure Java Driver)**

   * Converts JDBC calls directly into database protocol.
   * 100% Java, fast, platform-independent.
   * Most widely used (e.g., MySQL, PostgreSQL).

---

## 6. First JDBC Program

```java
// Import JDBC classes
import java.sql.*;

import com.mysql.jdbc.Driver;

import java.sql.*;

public  class Main {
    public static void main(String args[]) throws  ClassNotFoundException{
        String url= "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password= "Madupalli@2005";
        String query= "Select * from employee;";
        try {
            //Class.forName("com.mysql.jdbc.Driver");  // old version
            Class.forName("com.mysql.cj.jdbc.Driver"); // to load drivers
            System.out.println("Driver loaded successfully!!!");
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con= DriverManager.getConnection(url,username,password); // connection establishment
            System.out.println("Connection established successfully");
            Statement stmt= con.createStatement();
            ResultSet rs= stmt.executeQuery(query);
            while (rs.next()){
                int id= rs.getInt("id");
                String name= rs.getString("name");
                String job= rs.getString("job_title");
                double salary= rs.getDouble("salary");

                System.out.println();
                System.out.println("=========================================");
                System.out.print("ID: "+id);
                System.out.println("name: " +name);
                System.out.println("Job title: "+ job);
                System.out.println("Salary: "+ salary);
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection closed successfully");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
```

---

## 7. **Summary**

* JDBC is a standard **Java API** to interact with databases.
* Main **components**: Driver, DriverManager, Connection, Statement, ResultSet, SQLException.
* **Drivers** are of 4 types; most common is **Type 4 (Thin Driver)**.
* A JDBC program always follows: **Load Driver → Connect → Create Statement → Execute Query → Process Results → Close**.

---

