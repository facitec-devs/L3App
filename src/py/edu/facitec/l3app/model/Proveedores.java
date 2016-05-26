package py.edu.facitec.l3app.model;

import java.util.Date;

/**
 * 
 * @author rorogarcete
 *
 */
public class Proveedores {

	private int codigo;
	private String nombre;
	private String rucCi;
	private String telefono ;
	private String direccion;
	private Date fechaRegistro;
	
	public Proveedores(){
		super();
	}
	
	
	public Proveedores(int codigo, String nombre, String rucCi, String telefono, String direccion, Date fechaRegistro){
		this.codigo = 0;
		this.nombre = "";
		this.rucCi = "";
		this.telefono = "";
		this.direccion = "";
		this.fechaRegistro = new Date();
				
	} 
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRucCi() {
		return rucCi;
	}
	public void setRucCi(String rucCi) {
		this.rucCi = rucCi;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
}