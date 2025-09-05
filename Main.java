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