package dominio;

import patrones.CartaVisitor;

public class CartaItem extends Carta{
	
	private int bonificacion;
	
	public CartaItem(String nombreCarta, int rareza,int bonificacion) {
		super(nombreCarta, rareza, "Item");
		this.bonificacion = bonificacion;
	}

	public int getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
	}

	@Override
	public int visitar(CartaVisitor visitor) {
		return visitor.visitarItem(this);
	}

	@Override
	public String formatoArchivo() {
		return nombreCarta + ";" + rareza + ";" + tipo + ";" + bonificacion;
	}

}
