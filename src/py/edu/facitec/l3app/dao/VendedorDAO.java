package py.edu.facitec.l3app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import py.edu.facitec.l3app.model.Vendedor;
import py.edu.facitec.l3app.util.ConexionManager;

public class VendedorDAO {

	public static void guardarVendedor(Vendedor vendedor){
		String sql = "insert into db_vendedor (ven_codigo, ven_nombre, ven_direccion, ven_documento) values ("+vendedor.getCodigo()+", '"+vendedor.getNombre()+"','"+vendedor.getDireccion()+"', '"+vendedor.getDocumento()+"') ";

		System.out.println("SQL :" + sql);

		ConexionManager.abrirConexion();


		try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}ConexionManager.cerrarConexion();

	}



	public static Vendedor recuperarVendedorPorCodigo(int codigo) {
		String sql = "select * from db_vendedor where ven_codigo ="+codigo+"";
		ConexionManager.abrirConexion();
		Vendedor vendedor =  null;
		try {
			ResultSet rs = ConexionManager.stm.executeQuery(sql);
			if (rs.next()) {
				vendedor = new Vendedor();
				vendedor.setCodigo(rs.getInt("ven_codigo"));
				vendedor.setDireccion(rs.getString("ven_direccion"));
				vendedor.setDocumento(rs.getString("ven_documento"));
				vendedor.setTelefono(rs.getString("ven_telefono"));


			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConexionManager.cerrarConexion();
		return vendedor;
	}



	public static void modificarVendedor(Vendedor vd) {
		String sql="update db_vendedor set ven_nombre='"+vd.getNombre()+"',ven_documento="+vd.getDocumento()+",ven_direccion='"+vd.getDireccion()+"',ven_telefono='"+vd.getTelefono()+"' where ven_codigo="+vd.getCodigo()+"";
ConexionManager.abrirConexion();
try {
	ConexionManager.stm.executeUpdate(sql);
} catch (SQLException e) {
	e.printStackTrace();
}
ConexionManager.cerrarConexion();
	}




}
