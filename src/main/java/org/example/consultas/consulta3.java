package org.example.consultas;

import java.sql.*;
import java.util.Scanner;

public class consulta3
{
    public static void main(String[] args) {
        String url ="jdbc:postgresql://localhost:5432/pedidos";
        String sql="SELECT * FROM categorias WHERE categoriaid <?";
        try(Connection con = DriverManager.getConnection(url,"root","root");
            PreparedStatement ps=con.prepareStatement(sql);)
            {   Scanner ent = new Scanner(System.in);
                System.out.println("Introduce id cat");
                int n=ent.nextInt();
                ps.setInt(1,n);
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                    System.out.println(rs.getInt(1)+rs.getString(2));
                }

        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());

    }

}
}
