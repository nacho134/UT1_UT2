package org.example.create_delete_insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class createBBDD {
    public static void main(String[] args)
    {
        Connection con = null;
        try
        {
            String sqlurl= "jdbc:postgresql://localhost:5432/postgres";
            Connection connection = DriverManager.getConnection(sqlurl,"root","root");
            PreparedStatement ps=connection.prepareStatement ("CREATE DATABASE NACHOPEREZ");
            ps.execute();
            System.out.println("bbdd creada");
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }

}