package py.edu.facitec.l3app.dao;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import py.edu.facitec.l3app.model.Productos;
import py.edu.facitec.l3app.util.ConexionManager;

public class ProductoDao {

	public static void guardarProducto(Productos producto){
		String sql= "inset into tb_PRODUCTO (pro_codigo, pro_descripcion, pro_proveedor, pro_precio, pro_stock,pro_costo) "
				+ "values("+producto.getCodigo()+", '"+producto.getDescripcion()+"','"+producto.getProveedor()+"',"+producto.getPrecio()+", "+producto.getStock()+","+producto.getCosto()+"     )  ";
		ConexionManager.abrirConexion(); 
		try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		ConexionManager.cerrarConexion();
	}
	public static void eliminarProducto(){
	}
}