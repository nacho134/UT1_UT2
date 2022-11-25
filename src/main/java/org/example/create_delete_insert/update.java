package org.example.create_delete_insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class update
{

    private static Scanner ent = new Scanner(System.in);
    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5432/pedidos";
        String sql="UPDATE categorias" +
                "SET categoriaid=?, nombrecat=?";
        try(
                Connection con = DriverManager.getConnection(url,"root","root");
                PreparedStatement ps = con.prepareStatement(sql);
        )
        {
            System.out.println("introduce un nuevo idcat");
            ps.setInt(1,ent.nextInt());
            ent.nextLine();
            System.out.println("introduce un nuevo nombrecat");
            ps.setString(2,ent.nextLine());
            ps.executeQuery();
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }

    }

}
