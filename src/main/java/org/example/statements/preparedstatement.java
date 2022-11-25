package org.example.statements;

import java.sql.*;

public class preparedstatement
{
    public static void main(String[] args)
    {
     try (
    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/nachoperez", "root", "root");
    PreparedStatement ps = conn.prepareStatement("Select * From product");
    ResultSet rs =ps.executeQuery();)

    {
    while (rs.next())
    {
        System.out.println("id "+rs.getInt(1)+" nombre "+rs.getString(2));
    }
}   catch (
        SQLException ex)
        {
        System.err.println(ex.getMessage());
        }
}
}
