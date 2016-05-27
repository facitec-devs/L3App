package py.edu.facitec.l3app.model;

import java.util.Date;

public class Motivo {
	private int codigo;
	
	private int cantidad;
	private String motivo;
	private Date fecha;
	private boolean estado;
	
	public Motivo() {
		codigo=0;
		cantidad=0;
		motivo="";
		fecha= new Date();
		estado=true;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
