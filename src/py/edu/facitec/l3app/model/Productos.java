package py.edu.facitec.l3app.model;

public class Productos {
	private int codigo;
	private String descripcion;
	private String proveedor;
	private int precio;
	private int stock;
	private int costo;


	public Productos(){
		codigo=0;
		descripcion="";
		proveedor="";
		precio=0;
		stock=0;
		costo=0;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getProveedor() {
		return proveedor;
	}


	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getCosto() {
		return costo;
	}


	public void setCosto(int costo) {
		this.costo = costo;
	}




}
