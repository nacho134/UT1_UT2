package org.example.rollback;

import java.sql.*;

public class rollback {
    static Connection con = null;
    static ResultSet idGenerados=null;
    static PreparedStatement ps = null;
    public static void main(String[] args) throws SQLException {
        try
        {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pedidos","root","root");
            con.setAutoCommit(false);
            String sql = "INSERT INTO public.proveedores(\n" +
                    "\tproveedorid, nombreprov, contacto)\n" +
                    "\tVALUES (?, ?, ?);";

            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1,5);
            ps.setString(2,"Zara");
            ps.setString(3, "Jose Luis");

            ps.executeUpdate();


            idGenerados = ps.getGeneratedKeys();
            idGenerados.next();
            int idproveedor = idGenerados.getInt(1);
            ps.close();
            idGenerados.first();
            ps = con.prepareStatement(sql);
            ps.setInt(1,25);
            ps.setString(2,"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"); // es de mucho tamaño y hace roolback
            ps.setString(3,"perico");
            ps.executeUpdate();
           idGenerados.previous();
           idGenerados.moveToCurrentRow();
           idGenerados.moveToCurrentRow();

            con.commit();
        }
        catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }
        finally {
            try{
                con.setAutoCommit(true);
                idGenerados.close();
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}