package py.edu.facitec.l3app.model;

/**
 * 
 * @author rorogarcete
 *
 */
public class Persona {

	private int codigo;
	private String nombre;
	private String apellido;
	private String documento;
	
	public Persona() {
		super();
	}

	public Persona(int codigo, String nombre, String apellido, String documento) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
		
}