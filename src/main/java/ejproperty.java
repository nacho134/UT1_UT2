import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ejproperty
{
    public static void main(String[] args) {
        Properties ps=new Properties();
        ps.setProperty("nombre","nacho");
        ps.setProperty("apellidos","perez alted");
        ps.setProperty("materia","ad");
        try
        {
            ps.store(new FileWriter("examen.conf"),"propiedades del ex");
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }


    }
}
