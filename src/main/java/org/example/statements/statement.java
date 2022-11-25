package org.example.statements;

import org.postgresql.Driver;

import java.rmi.ServerError;
import java.sql.*;

public class statement
{
    public static void main(String[] args)
    {

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/nachoperez", "root", "root");
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("select * from product")) {
            while (rs.next())
            {
                System.out.println("id "+rs.getInt(1)+" nombre "+rs.getString(2));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
