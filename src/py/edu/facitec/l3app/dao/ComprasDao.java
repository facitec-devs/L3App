package py.edu.facitec.l3app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import py.edu.facitec.l3app.model.Compras;
import py.edu.facitec.l3app.util.ConectionManager;


public class ComprasDao {
	
	
	public static void guradarCompras(Compras compras){
		String sql = "insert into tb_compras(com_cantidad, com_costo, com_precioventa, com_descripcion, com_deposito) values"
				+ "("+compras.getCantidad()+","+compras.getCosto()+","+compras.getPrecioVenta()+","
						+ "'"+compras.getDescripcion()+"',"+compras.getDeposito()+") ";
		
		System.out.println("SQl : " +sql);
		
		ConectionManager.abrirConexion();
		
		try {
			ConectionManager.stm.executeUpdate(sql);
			System.out.println("Conectado Exitosamente");
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		ConectionManager.cerrarConexion();
	}
	public static Compras recuperarComprasPorCodigo(int codigo) {
		String sql = "select * from tb_compras where com_codigo = "+codigo+" ";
		
		ConectionManager.abrirConexion();

		Compras compras = null;
		
		try {
			ResultSet rs = ConectionManager.stm.executeQuery(sql);
			
			if ( rs.next() ) {
				compras = new Compras(); //creamos un objeto
				
				compras.setCantidad(rs.getInt("com_cantidad"));
				compras.setCosto(rs.getDouble("com_costo"));
				compras.setPrecioVenta(rs.getDouble("com_precioventa"));
				compras.setDescripcion(rs.getString("com_descripcion"));
				
				compras.setDeposito(rs.getInt("com_deposito"));
	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConectionManager.cerrarConexion(); //cerramos la conexion
		
		return compras; //retorna el objeto cliente
	}
	public static void modificarCompras(Compras compras) {
		String sql = "update tb_compras set "
				+ "com_cantidad = "+compras.getCantidad()+","
				+ "com_costo = "+compras.getCosto()+","
				+ "com_precioventa = "+compras.getPrecioVenta()+","
				+ "com_descripcion = '"+compras.getDescripcion()+"',"
				+ "com_deposito = "+compras.getDeposito()+" where "
				+ "com_codigo = "+compras.getCodigo()+"  ";
		
		ConectionManager.abrirConexion(); //abro la conexion
		
		try {
			ConectionManager.stm.executeUpdate(sql); //mando ejecutar el sql
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		ConectionManager.cerrarConexion(); //cierro la conexion
	}
	public static void eliminarComprasPorCodigo(int codigo) {
		String sql = "delete from tb_compras where com_codigo = "+codigo+" ";
	
		ConectionManager.abrirConexion();
		
		try {
			ConectionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConectionManager.cerrarConexion();
	
	

}
}
