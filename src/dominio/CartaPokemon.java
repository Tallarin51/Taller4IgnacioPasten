package dominio;

import patrones.CartaVisitor;

public class CartaPokemon extends Carta{
	
	private int daño;
	private int cantEnergias;
	
	public CartaPokemon(String nombreCarta, int rareza, int daño, int cantEnergias) {
		super(nombreCarta, rareza, "Pokemon");
		this.daño = daño;
		this.cantEnergias = cantEnergias;
	}
	
	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

	public int getCantEnergias() {
		return cantEnergias;
	}

	public void setCantEnergias(int cantEnergias) {
		this.cantEnergias = cantEnergias;
	}

	@Override
	public int visitar(CartaVisitor visitor) {
		return visitor.visitarPokemon(this);
	}
	
}
