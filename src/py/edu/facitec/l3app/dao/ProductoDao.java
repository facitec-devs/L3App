package py.edu.facitec.l3app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import py.edu.facitec.l3app.model.Productos;
import py.edu.facitec.l3app.util.ConexionManager;
public class ProductoDao {

	public static void guardarProducto(Productos producto){
		String sql= "insert into tb_PRODUCTO (pro_codigo, pro_descripcion, pro_proveedor, pro_precio, pro_stock,pro_costo) "
				+ "values("+producto.getCodigo()+", '"+producto.getDescripcion()+"','"+producto.getProveedor()+"',"+producto.getPrecio()+", "+producto.getStock()+","+producto.getCosto()+"     )  ";
		ConexionManager.abrirConexion(); 
		try {
			ConexionManager.stm.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "PRODUCTO GUARDADO");
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		ConexionManager.cerrarConexion();
	}
	public static void modificarCliente(Productos producto){	

		String sql="update tb_PRODUCTO set pro_descripcion='"+producto.getDescripcion()+"', pro_proveedor='"+producto.getProveedor()+"', pro_precio="+producto.getPrecio()+",pro_stock="+producto.getStock()+",pro_costo="+producto.getCosto()+" where	pro_codigo="+producto.getCodigo()+"		"; 
		ConexionManager.abrirConexion();
		try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConexionManager.cerrarConexion();
	}
	public static void eliminarProdcutoPorCodigo(int codigo){
		String sql= "delete from tb_PRODUCTO where pro_codigo= "+codigo+"";
		ConexionManager.abrirConexion();
		try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConexionManager.cerrarConexion();
	}
	public static Productos recuperarProductoPorCodigo(int codigo){
		String sql= "select * from tb_PRODUCTO where pro_codigo= "+codigo+" ";
		ConexionManager.abrirConexion();
		Productos producto= null;
		try {
			ResultSet rs= ConexionManager.stm.executeQuery(sql);
			if(rs.next()){
				producto= new Productos();
				producto.setDescripcion(rs.getString("pro_descripcion"));
				producto.setProveedor(rs.getString("pro_proveedor"));
				producto.setPrecio(rs.getInt("pro_precio"));
				producto.setStock(rs.getInt("pro_stock"));
				producto.setCosto(rs.getInt("pro_costo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConexionManager.cerrarConexion();
		return producto;
	}	
}