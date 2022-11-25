package org.example.create_delete_insert;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class insert
{

    private static Scanner ent=new Scanner(System.in);
    public static void main(String[] args) {


        Connection con=null;
        String insert="INSERT INTO public.categorias(" +
                "categoriaid, nombrecat)" +
                "VALUES (?, ?);";
        String url="jdbc:postgresql://localhost:5432/pedidos";
        try(
            Connection connection= DriverManager.getConnection(url,"root","root");
            PreparedStatement ps= connection.prepareStatement(insert);)
        {
            int n=1;
            while(n!=0)
            {
            System.out.println("Introduce la categoria id");
            ps.setInt(1,ent.nextInt());
            ent.nextLine();
            System.out.println("Introduce la nombrecat");
            ps.setString(2,ent.nextLine());
                System.out.println("0 para acabar programa si no continuas");
                n=ent.nextInt();


                ps.execute();
            }
           // System.out.println("tabla creada");
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
