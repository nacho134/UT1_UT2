import java.sql.*;

public class consulta
{
    public static void main(String[] args) {
        String url="jdbc:postgresql://localhost:5432/pedidos";
       // String sql="";
        try(Connection con= DriverManager.getConnection(url,"root","root");
            PreparedStatement ps= con.prepareStatement("Select * FROM categorias WHERE categoriaid<?");)
        {
            ps.setInt(1,500);
            ResultSet rs=ps.executeQuery();
            System.out.println("registros con categoria id <500");
            while(rs.next())
            {
                System.out.println("catid"+rs.getInt(1)+" nmbre cat "+rs.getString(2));
            }
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
