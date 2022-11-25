/*
package org.example.function_procedure;


import org.postgresql.jdbc2.optional.ConnectionPool;

import java.sql.*;

public class procedimientos
{
    public static void main(String[] args)
    {
        String sqlprocedure = "call borracategorias2(?)";
        String sqlfunction = "SELECT cuentaEjercicios()";
        try(Connection conn = ConnectionPool.getInstance().getConnection();
            CallableStatement cs = conn.prepareCall(sqlprocedure);
            PreparedStatement ps = conn.prepareStatement(sqlfunction,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = ps.executeQuery())
        {
            //procedure
            cs.execute();
            System.out.println("La categoria se ha borrado");
            //funcion
            resultSet.first();
            if(resultSet.getInt(1)>0)
                System.out.println("Hay "+resultSet.getString(1)+" ejercicios.");
            else
                System.out.println("No hay ningun ejercicio almacenado");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}*/