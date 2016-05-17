package py.edu.facitec.l3app.model;

import java.util.Date;

public class Categoria {
	
	private int id;
	private Date fecha;
	private String nomenclatura;
	private String descripcion;
	private boolean estado;
	
	public Categoria(){
		this.id = 0;
		this.fecha = new Date();
		this.nomenclatura ="";
		this.descripcion = "";
		this.estado = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNomenclatura() {
		return nomenclatura;
	}

	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	

}
