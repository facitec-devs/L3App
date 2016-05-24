package py.edu.facitec.l3app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import py.edu.facitec.l3app.model.Cliente;
import py.edu.facitec.l3app.util.ConexionManager;

public class ClienteDao {
	
	
	public static void guardarCliente(Cliente cliente){
		String sql = "insert into tb_cliente(cli_nombre, cli_ruc, cli_telefono, cli_email, cli_direccion, cli_activo, cli_fecha_registro,"
				+ "cli_sueldo) values ('"+ cliente.getNombre() +"', '"+ cliente.getRuc() +"', '"+ cliente.getTelefono() +"',"
						+ "'"+ cliente.getEmail() +"', '"+ cliente.getDireccion() +"', "+ cliente.isActivo() +", '"+ cliente.getFecha_registro() +"',"
								+ ""+ cliente.getSueldo() +" )";
		
		
		ConexionManager.abrirConexion();
		
			try {
				ConexionManager.stm.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
		ConexionManager.cerrarConexion();
			}
			
			
	}
	
	public static Cliente recuperarClientePorCodigo(int codigo){
		
		String sql = "select * from tb_cliente where cli_codigo = "+ codigo +" ";
		
		ConexionManager.abrirConexion();
		
		Cliente cliente = null;
		
		try {
			ResultSet rs = ConexionManager.stm.executeQuery(sql);
			
			if (rs.next()){
				
				cliente = new Cliente(); 
				cliente.setNombre(rs.getString("cli_nombre"));
				cliente.setRuc(rs.getString("cli_ruc"));
				cliente.setTelefono(rs.getString("cli_telefono"));
				cliente.setEmail(rs.getString("cli_email"));
				cliente.setDireccion(rs.getString("cli_direccion"));
				cliente.setActivo(rs.getBoolean("cli_activo"));
				cliente.setFecha_registro(rs.getDate("cli_fecha_registro"));
				cliente.setSueldo(rs.getDouble("cli_sueldo"));
					
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			ConexionManager.cerrarConexion();
		}
		
		
		return cliente;
	}
	
	public static void modificarCliente(Cliente cliente){
		String sql = "update tb_cliente set cli_nombre = '"+ cliente.getNombre() +"', cli_ruc = '"+ cliente.getRuc()+"',"
				+ " cli_telefono = '"+ cliente.getTelefono() +"', cli_email = '"+ cliente.getEmail() +"',"
						+ " cli_direccion = '"+ cliente.getDireccion() +"', cli_activo = "+ cliente.isActivo() +", "
								+ "cli_sueldo = "+ cliente.getSueldo() +" where cli_codigo = "+ cliente.getCodigo() +" ";
		
		ConexionManager.abrirConexion();
		
			try {
				ConexionManager.stm.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ConexionManager.cerrarConexion();
		
	}
	
	public static void eliminarClientePorCodigo(int codigo){
		
		String sql = "delete from tb_cliente where cli_codigo = "+ codigo +"";
		
		ConexionManager.abrirConexion();
		
		try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConexionManager.cerrarConexion();
		
	}

}
