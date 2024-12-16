import java.sql.ResultSet;

public class Roles {
    private int id;
    private String nombre;


    public boolean alta (){
        String comando = "INSERT INTO roles VALUES ("+ this.id+ ", '"+this.nombre+"');";
        // Lo ejecutamos
    }

    public static ResultSet listado() {
        // Ejecuta un SELECT y regresa el ResultSet obtenido
        // resultado = Roles.listado();
        ResultSet resultado = null;
        return resultado;
    }

    // Roles nuevo = new Roles();

    // nuevo.alta();
}
