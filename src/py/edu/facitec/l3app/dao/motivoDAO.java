package py.edu.facitec.l3app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import py.edu.facitec.l3app.model.Motivo;
import py.edu.facitec.l3app.util.ConexionManager;

public class motivoDAO {
	public static void guardarMotivo(Motivo motivo){
		String sql="insert into tb_motivo (pro_id,pro_cantidad, pro_motivo_baja,pro_activo) values("+motivo.getCodigo()+","+motivo.getCantidad()+",'"+motivo.getMotivo()+"',"+motivo.isEstado()+")";
		ConexionManager.abrirConexion(); 
		try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		ConexionManager.cerrarConexion();
	}
	public static void eliminarMotivo(int codigo){
		String sql="delete from tb_motivo where pro_id="+codigo+" ";

		ConexionManager.abrirConexion();

		try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexionManager.cerrarConexion();	

	}
	public static void modificarMotivo(Motivo motivo){

		String sql="update tb_motivo set pro_cantidad= "+motivo.getCantidad()+", pro_motivo_baja= '"+motivo.getMotivo()+"',pro_activo= "+motivo.isEstado()+"  where pro_id="+motivo.getCodigo()+" ";
		ConexionManager.abrirConexion(); 
		try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		ConexionManager.cerrarConexion();
	}
}

