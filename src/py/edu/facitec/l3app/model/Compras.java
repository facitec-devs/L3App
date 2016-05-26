package py.edu.facitec.l3app.model;

public class Compras {

	private int codigo;
	private int cantidad;
	private String descripcion;
	private double costo;
	private double precioVenta;
	private int deposito;

	public Compras() {
		super();
	}

	public Compras(int codigo, int cantidad, String descripcion, double costo, double precioVenta, int deposito) {
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.costo = costo;
		this.precioVenta = precioVenta;
		this.deposito = deposito;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getDeposito() {
		return deposito;
	}

	public void setDeposito(int deposito) {
		this.deposito = deposito;
	}

}
