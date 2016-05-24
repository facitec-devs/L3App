package py.edu.facitec.l3app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class ConectionManager {
	
	private static Connection conection; //abre una secion con la BD
	public static Statement stm; //ejecuta la sentencia sql en la BD
	//declarar constantes 
	private static final String URL = "jdbc:postgresql://localhost:5432/db_negocios";
	private static final String USER= "postgres";
	private static final String PASSWORD = "12345";
	
	public static Connection abrirConexion(){
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("conexion con sucesso");
		} catch (ClassNotFoundException e) {
			System.out.println("conexion con error");
			e.printStackTrace();
		}
		                                           //url, usuario, password
		try {
			conection = DriverManager.getConnection(URL, USER, PASSWORD);
			stm = conection.createStatement();//listo para recibir sentencias sql
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conection;
		
	}
	
	public static void cerrarConexion(){
		if (conection !=null){
			try {
				stm.close();//cierro la sentencia
				conection.close();//cierro la coneccion
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ConectionManager.abrirConexion();
	}

}
