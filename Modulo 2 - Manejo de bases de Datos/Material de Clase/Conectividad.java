import java.sql.*;
import java.time.LocalDateTime;

public class Conectividad {
    public static ResultSet selectBD(String comandoSelect) {
        boolean resultado=true;
        // 1. Conexión a la base de datos
        /// 1.1 Cadena de conexión
        String servidor="127.0.0.1", baseDD="sistema";
        String usuario="root", contrasena="sqlMD3";

        String cadenaDeConexion = "jdbc:mariadb://"+servidor+"/"+baseDD;
        /// 1.2 Conexión
        Connection conexion;   // Creación del objeto
        ResultSet registros=null;
        try {
            conexion = DriverManager.getConnection(cadenaDeConexion, usuario, contrasena);
            System.out.println("Conexión establecida con el servidor...");

            // 2. Creación de comando
            System.out.println("Comando a ejecutar: "+comandoSelect);

            // 3. Ejecución de comando
            Statement instruccion;

            int codigoRetorno=0;
            instruccion = conexion.createStatement();
            registros = instruccion.executeQuery(comandoSelect);   // executeQuery()  regresa ResultSet

            System.out.println("Comando ejecutado ");
            // 4. Revisión de resultados/excepción

            System.out.println("Registros afectados en el SELECT: "+instruccion.getUpdateCount());

            // 5. Cierre de objetos
            instruccion.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error en la conexión con la base de datos "+ e.getErrorCode());
            System.out.println("\t"+e);
            resultado=false;
        }
        return registros;

    }
    public static boolean actualizacionBD(String comando){
        boolean resultado=true;
        // 1. Conexión a la base de datos
        /// 1.1 Cadena de conexión
        String servidor="127.0.0.1", baseDD="sistema";
        String usuario="root", contrasena="sqlMD3";

        String cadenaDeConexion = "jdbc:mariadb://"+servidor+"/"+baseDD;
        /// 1.2 Conexión
        Connection conexion;   // Creación del objeto
        try {
            conexion = DriverManager.getConnection(cadenaDeConexion, usuario, contrasena);
            System.out.println("Conexión establecida con el servidor...");

            // 2. Creación de comando
            System.out.println("Comando a ejecutar: "+comando);

            // 3. Ejecución de comando
            Statement instruccion;
            int codigoRetorno;
            instruccion = conexion.createStatement();
            codigoRetorno=instruccion.executeUpdate(comando);
            // - Número de registros afectados
            // - 0 Si no hay registros afectados
            System.out.println("Comando ejecutado con el código: "+codigoRetorno);
            // 4. Revisión de resultados/excepción
            // Con el código de retorno o con los registros afectados.
            System.out.println("Registros afectados: "+instruccion.getUpdateCount());

            // 5. Cierre de objetos
            instruccion.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error en la conexión con la base de datos "+ e.getErrorCode());
            System.out.println("\t"+e);
            resultado=false;
        }
        return resultado;
    }
    public static void main(String[] args) {
        System.out.println("Ejemplo de conectividad con una bbdd MariaDB");
        String comando ="INSERT INTO usuarios (usuario, idRol, correo, contrasena, estatus) VALUES " +
                "('Carlos',2,'eligio@eligio.com','123456','A')";
        actualizacionBD(comando);

        ResultSet datos1 = selectBD ("SELECT * FROM usuarios;");
        // idUsuario, usuario, idRol, correo, contrasena, estatus
        try {
            System.out.println("ID\tUSUARIO");

            while (datos1.next()) {  // Recorre el resultado mientras haya datos
                System.out.print(datos1.getInt("idUsuario") + "\t");  // Extracción por nombre
                System.out.println(datos1.getString(2));       // Extracción por posición
            }
            datos1.close();
        } catch (SQLException e){
            System.out.println("Error al extraer los datos de usuarios");
        }


        actualizacionBD("DELETE FROM usuarios WHERE idUsuario>5");

        ResultSet datos2 = selectBD("SELECT * FROM bitacora;");
        //idBitacora, idUsuario, cveModulo, fecha
        try {
            ResultSetMetaData metadatos = datos2.getMetaData();
            int campos = metadatos.getColumnCount();
            int i;
            System.out.println("Columnas extraídas: "+campos);
            for (i=1; i<=campos;i++){
                System.out.print(metadatos.getColumnName(i).toUpperCase()+"\t");
            }
            System.out.println();

            while (datos2.next()) {  // Recorre el resultado mientras haya datos
                for (i=1; i<=campos;i++){
                    System.out.print(datos2.getString(i)+"\t");

                }
                LocalDateTime ldt = datos2.getTimestamp("fecha").toLocalDateTime();
                System.out.println(datos2.getTimestamp("fecha")+"\t"+ldt);
                System.out.println();
            }
            datos2.close();
        } catch (SQLException e){
            System.out.println("Error al extraer los datos de la bitácora");
        }

    }
}
