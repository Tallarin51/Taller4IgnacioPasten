package dominio;

import patrones.CartaVisitor;

public class CartaEnergy extends Carta{
	
	private String elemento;
	
	public CartaEnergy(String nombreCarta, int rareza, String elemento) {
		super(nombreCarta, rareza, "Energy");
		this.elemento = elemento;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	@Override
	public int visitar(CartaVisitor visitor) {
		return visitor.visitarEnergy(this);
	}

	@Override
	public String formatoArchivo() {
		return nombreCarta + ";" + rareza + ";" + tipo + ";" + elemento;
	}
	
}
