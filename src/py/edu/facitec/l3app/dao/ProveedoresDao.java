package py.edu.facitec.l3app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import py.edu.facitec.l3app.model.Proveedores;
import py.edu.facitec.l3app.util.ConexionManager;

public class ProveedoresDao {
	
	public static void guardarProveedores(Proveedores proveedores){
	String sql = "insert into tb_proveedores(pro_nombre,pro_rucci,pro_telefono,pro_direccion,pro_fecharegistro) values"
			+ "('"+proveedores.getNombre()+"',"
					+ "'"+proveedores.getRucCi()+"', "
					+ "'"+proveedores.getTelefono()+"',"
					+ "'"+proveedores.getDireccion()+"',"
					+ "'"+proveedores.getFechaRegistro()+"')";
	
	System.out.println("SQl" +sql);
	
	ConexionManager.abrirConexion();
	
	try {
		ConexionManager.stm.executeUpdate(sql);
		System.out.println("Ejecutado exitosamente");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ConexionManager.cerrarConexion();
	}
	public static Proveedores recuperarProveedoresPorCodigo(int codigo){
		String sql = "select * from tb_proveedores where pro_codigo = "+codigo+"";
		
		ConexionManager.abrirConexion();
		
		Proveedores proveedores = null;
		
		try {
			ResultSet rs = ConexionManager.stm.executeQuery(sql);
			
			if(rs.next()){
				proveedores = new Proveedores();
				proveedores.setNombre(rs.getString("pro_nombre"));
				proveedores.setRucCi(rs.getString("pro_rucci"));
				proveedores.setTelefono(rs.getString("pro_telefono"));
				proveedores.setDireccion(rs.getString("pro_direccion"));
				proveedores.setFechaRegistro(rs.getDate("pro_fecharegistro"));
				
			}
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexionManager.cerrarConexion();
		return proveedores;
			
		}
	public static void modificarProveedores(Proveedores proveedores){
			String sql = "update tb_proveedores set "
					+ "pro_nombre = '"+proveedores.getNombre()+"',"
					+ "pro_rucci = '"+proveedores.getRucCi()+"',"
					+ "pro_telefono = '"+proveedores.getTelefono()+"',"
					+ "pro_direccion = '"+proveedores.getDireccion()+"',"
					+ "pro_fecharegistro = '"+proveedores.getFechaRegistro()+"' where "
					+ "pro_codigo = "+proveedores.getCodigo()+"  ";
			
			
			ConexionManager.abrirConexion();
			
			try {
				ConexionManager.stm.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ConexionManager.cerrarConexion();
	}
	public static void eliminarProveedoresPorCodigo(int codigo){
		String sql = "delete from tb_proveedores where pro_codigo = "+codigo+"";
		
		
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
	


