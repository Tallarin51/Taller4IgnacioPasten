package dominio;

public class CartaEnergy extends Carta{
	
	private String elemento;
	
	public CartaEnergy(String nombreCarta, int rareza, String tipo, String elemento) {
		super(nombreCarta, rareza, "Energy");
		this.elemento = elemento;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}
	
}
