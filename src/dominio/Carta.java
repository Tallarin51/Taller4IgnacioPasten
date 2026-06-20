package dominio;

import patrones.CartaVisitor;

public abstract class Carta {

	protected String nombreCarta;
	protected int rareza;
	protected String tipo;
	protected String rutaImagen;

	public Carta(String nombreCarta, int rareza, String tipo) {
		super();
		this.nombreCarta = nombreCarta;
		this.rareza = rareza;
		this.tipo = tipo;
		this.rutaImagen = "imagenes/" + nombreCarta + ".jpg";
	}
	
	public abstract int visitar(CartaVisitor visitor);
	
	public abstract String formatoArchivo();
	
	public String getNombreCarta() {
		return nombreCarta;
	}
	public void setNombreCarta(String nombreCarta) {
		this.nombreCarta = nombreCarta;
	}
	public int getRareza() {
		return rareza;
	}
	public void setRareza(int rareza) {
		this.rareza = rareza;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	
	
}
