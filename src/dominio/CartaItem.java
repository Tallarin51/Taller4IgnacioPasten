package dominio;

public class CartaItem extends Carta{
	
	private int bonificacion;
	
	public CartaItem(String nombreCarta, int rareza, String tipo, int bonificacion) {
		super(nombreCarta, rareza, "Item");
		this.bonificacion = bonificacion;
	}

	public int getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
	}

}
