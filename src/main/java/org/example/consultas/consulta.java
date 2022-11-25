package org.example.consultas;

import java.sql.*;
import java.util.Scanner;

public class consulta

{
    private static Scanner ent = new Scanner(System.in);

    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5432/pedidos";
        //String sql="Select * From categorias WHERE categoriaid<=?";
        try(
                Connection con = DriverManager.getConnection(url,"root","root");
                PreparedStatement ps = con.prepareStatement("Select * From categorias WHERE categoriaid<=?");
                ResultSet rs =ps.executeQuery();

        )
        {
            System.out.println("Introduce id");
            int col=ent.nextInt();
            ps.setInt(1,col);
            while(rs.next())
            {
                System.out.println("id"+rs.getInt("categoriaid")+" categoria"+rs.getString("nombrecat"));
            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }

    }

}
