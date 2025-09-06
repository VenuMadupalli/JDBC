// Day - 01
//
//import com.mysql.jdbc.Driver;
//import java.sql.*;
//
//public  class Main {
//    public static void main(String args[]) throws  ClassNotFoundException{
//        String url= "jdbc:mysql://localhost:3306/mydatabase";
//        String username = "root";
//        String password= "Madupalli@2005";
//        String query= "Select * from employee;";
//        try {
//            //Class.forName("com.mysql.jdbc.Driver");  // old version
//            Class.forName("com.mysql.cj.jdbc.Driver"); // to load drivers
//            System.out.println("Driver loaded successfully!!!");
//        }
//        catch (ClassNotFoundException e){
//            System.out.println(e.getMessage());
//        }
//        try{
//            Connection con= DriverManager.getConnection(url,username,password); // connection establishment
//            System.out.println("Connection established successfully");
//            Statement stmt= con.createStatement();
//            ResultSet rs= stmt.executeQuery(query);
//            while (rs.next()){
//                int id= rs.getInt("id");
//                String name= rs.getString("name");
//                String job= rs.getString("job_title");
//                double salary= rs.getDouble("salary");
//
//                System.out.println();
//                System.out.println("=========================================");
//                System.out.print("ID: "+id);
//                System.out.println("name: " +name);
//                System.out.println("Job title: "+ job);
//                System.out.println("Salary: "+ salary);
//            }
//            rs.close();
//            stmt.close();
//            con.close();
//            System.out.println("Connection closed successfully");
//        }
//        catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }
//}



// day-02
// Insertion
//import java.sql.*;
//
//public  class Main {
//    public static void main(String args[]) throws  ClassNotFoundException{
//        String url= "jdbc:mysql://localhost:3306/mydatabase";
//        String username = "root";
//        String password= "Madupalli@2005";
//        String query= "INSERT INTO employee(id, name, job_title, salary) VALUES (5, 'upi','Developer', 100000.0),(6,'Ram','testing', 150000.0);";
//        try {
//            //Class.forName("com.mysql.jdbc.Driver");  // old version
//            Class.forName("com.mysql.cj.jdbc.Driver"); // to load drivers
//            System.out.println("Driver loaded successfully!!!");
//        }
//        catch (ClassNotFoundException e){
//            System.out.println(e.getMessage());
//        }
//        try{
//            Connection con= DriverManager.getConnection(url,username,password); // connection establishment
//            System.out.println("Connection established successfully");
//            Statement stmt= con.createStatement();
//            int rowsaffected= stmt.executeUpdate(query);
//            if(rowsaffected>0){
//                System.out.println(rowsaffected +" rows affected");
//            }
//            else{
//                System.out.println("Insertion failed");
//            }
//
//            stmt.close();
//            con.close();
//            System.out.println("Connection closed successfully");
//        }
//        catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }
//}


// deletion
//import java.sql.*;
//public  class Main {
//    public static void main(String args[]) throws  ClassNotFoundException{
//        String url= "jdbc:mysql://localhost:3306/mydatabase";
//        String username = "root";
//        String password= "Madupalli@2005";
//        String query= "delete from employee where id=6;";
//        try {
//            //Class.forName("com.mysql.jdbc.Driver");  // old version
//            Class.forName("com.mysql.cj.jdbc.Driver"); // to load drivers
//            System.out.println("Driver loaded successfully!!!");
//        }
//        catch (ClassNotFoundException e){
//            System.out.println(e.getMessage());
//        }
//        try{
//            Connection con= DriverManager.getConnection(url,username,password); // connection establishment
//            System.out.println("Connection established successfully");
//            Statement stmt= con.createStatement();
//            int rowsaffected= stmt.executeUpdate(query);
//            if(rowsaffected>0){
//                System.out.println(rowsaffected +" rows affected");
//            }
//            else{
//                System.out.println("Insertion failed");
//            }
//
//            stmt.close();
//            con.close();
//            System.out.println("Connection closed successfully");
//        }
//        catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }
//}



// updations
import java.sql.*;
public  class Main {
    public static void main(String args[]) throws  ClassNotFoundException{
        String url= "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password= "Madupalli@2005";
        String query= "update employee set job_title='Developer' where id=4;";
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
            int rowsaffected= stmt.executeUpdate(query);
            if(rowsaffected>0){
                System.out.println(rowsaffected +" rows affected");
            }
            else{
                System.out.println("Insertion failed");
            }

            stmt.close();
            con.close();
            System.out.println("Connection closed successfully");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}


