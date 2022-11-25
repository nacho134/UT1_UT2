package org.example.create_delete_insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class delete
{
    private static Scanner ent = new Scanner(System.in);
    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5432/nachoperez";
        String sql="DROP TABLE table1";
                try(Connection con= DriverManager.getConnection(url,"root","root");
                    PreparedStatement ps= con.prepareStatement(sql);
                    )
                {

                    ps.execute();

                }
                catch(SQLException e)
                {
                    System.err.println(e.getMessage());
                }
    }}
