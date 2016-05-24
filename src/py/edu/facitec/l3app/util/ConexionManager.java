package py.edu.facitec.l3app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionManager {

	private static Connection conexion;
	public static Statement stm;


	private final static String user= "postgres";  
	private final static String cont= "123456";
	private final static String url="jdbc:postgresql://localhost:5432/bd_vendedor";

	public static Connection abrirConexion(){
		try {
			Class.forName("org.postgresql.Driver");
            System.out.println("conexion con succeso ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conexion=DriverManager.getConnection(url,user,cont);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		ConexionManager.abrirConexion();
	}
}