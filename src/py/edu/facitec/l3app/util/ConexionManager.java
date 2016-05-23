package py.edu.facitec.l3app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionManager {
	private static Connection conexion;
	public static Statement stm;
	private static final String DIRECCION="jdbc:postgresql://localhost:5432/db_motivobaja";
	public static final String USUARIO="postgres";
	public static final String CONTRASENA="12345";
	
	public static Connection abrirConexion(){
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("funciona");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conexion=DriverManager.getConnection(DIRECCION, USUARIO, CONTRASENA);
			stm= conexion.createStatement();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return conexion;
		
	}
	public static void cerrarConexion(){
		if(conexion!=null){
			try {
				stm.close();
				conexion.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ConexionManager.abrirConexion();
	
	}
		

}
