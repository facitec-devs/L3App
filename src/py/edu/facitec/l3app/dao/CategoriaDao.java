package py.edu.facitec.l3app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import py.edu.facitec.l3app.model.Categoria;
import py.edu.facitec.l3app.util.ConectionManager;

public class CategoriaDao {
	
	public static void guardarCategoria(Categoria categoria){
		String sql = "insert into tb_categorias (cat_fecha, cat_nomenclatura, cat_descripcion, cat_estado) "
				+ "values ('"+categoria.getFecha()+"', '"+categoria.getNomenclatura()+"',"
						+ "'"+categoria.getDescripcion()+"', "+categoria.isEstado()+")";
		
		System.out.println("SQL :"+ sql);
		
		ConectionManager.abrirConexion();
		
		try {
			ConectionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConectionManager.cerrarConexion();	
	}
	
	public static Categoria recuperarCategoriaPorCodigo(int codigo){
		String sql = " select * from tb_categorias where cat_id = "+codigo+"";
		ConectionManager.abrirConexion();
		Categoria categoria = null;
		try {
			ResultSet rs = ConectionManager.stm.executeQuery(sql);
			if(rs.next()){
				categoria = new Categoria();
				categoria.setFecha(rs.getDate("cat_fecha"));
				categoria.setNomenclatura(rs.getString("cat_nomenclatura"));
				categoria.setDescripcion(rs.getString("cat_descripcion"));
				categoria.setEstado(rs.getBoolean("cat_estado"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConectionManager.cerrarConexion();
		return categoria;
	}
	
	public static void modificarCategoria(Categoria categoria){
		String sql = "update tb_categorias set cat_fecha = '"+categoria.getFecha()+"', "
				+ "cat_nomenclatura = '"+categoria.getNomenclatura()+"' ,"
				+ "cat_descripcion = '"+categoria.getDescripcion()+"', "
				+ "cat_estado = '"+categoria.isEstado()+"'"
						+ "where cat_id = "+categoria.getId()+"";
		
		System.out.println("SQL update = "+sql);
		ConectionManager.abrirConexion();
		try {
			ConectionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConectionManager.cerrarConexion();
	}
	
	public static void eliminarCategoria(int codigo){
		String sql=" delete from tb_categorias where cat_id = "+codigo+" ";
		ConectionManager.abrirConexion();
		try {
			ConectionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConectionManager.cerrarConexion();
	}	

}
