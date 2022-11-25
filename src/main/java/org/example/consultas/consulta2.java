package org.example.consultas;

import java.sql.*;
import java.util.Scanner;

public class consulta2
{
    private static Scanner ent = new Scanner(System.in);
    public static void main(String[] args)
    {
        String url="jdbc:postgresql://localhost:5432/pedidos";
        String sql="Select * FROM categorias WHERE categoriaid<?";
                try(Connection con = DriverManager.getConnection(url,"root","root");
                    PreparedStatement ps= con.prepareStatement(sql);)
                {
                    System.out.println("Introduce el valor de las cat");
                    int n=ent.nextInt();
                    ps.setInt(1,n);
                    ResultSet rs= ps.executeQuery();
                    while(rs.next())
                    {
                        System.out.println("idcat "+rs.getInt(1)+" nomcat "+rs.getString(2));
                    }
                }
                catch (SQLException e)
                {
                    System.err.println(e.getMessage());
                 }
}
}
