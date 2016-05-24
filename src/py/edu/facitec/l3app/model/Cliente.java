package py.edu.facitec.l3app.model;

import java.util.Date;

public class Cliente {
	
	private int codigo;
	private String nombre;
	private String ruc;
	private String telefono;
	private String email;
	private String direccion;
	private boolean activo;
	private Date fecha_registro;
	private double sueldo;
	
	
	public Cliente (){
		
		this.codigo=0;
		this.nombre="";
		this.ruc="";
		this.telefono="";
		this.email="";
		this.direccion="";
		this.activo = false;
		this.fecha_registro= new Date();
		this.sueldo=0;
		
		
		
		
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


	public String getRuc() {
		return ruc;
	}


	public void setRuc(String ruc) {
		this.ruc = ruc;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}


	public Date getFecha_registro() {
		return fecha_registro;
	}


	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}


	public double getSueldo() {
		return sueldo;
	}


	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	

}
