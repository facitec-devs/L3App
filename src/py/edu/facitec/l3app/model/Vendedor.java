package py.edu.facitec.l3app.model;

import java.util.Date;

/**
 * 
 * @author rorogarcete
 *
 */
public class Vendedor {

	private int codigo;
	private String nombre;
	private String documento;
	private String direccion;
	private String telefono;
	
	public Vendedor() {
		codigo=0;
		nombre="";
		documento="";
		direccion="";
		telefono="";
		
		
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	

	}