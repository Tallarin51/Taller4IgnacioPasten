package dominio;

import patrones.CartaVisitor;

public class CartaSupporter extends Carta{
	
	private int efectosPorTurno;
	
	public CartaSupporter(String nombreCarta, int rareza, int efectosPorTurno) {
		super(nombreCarta, rareza, "Supporter");
		this.efectosPorTurno = efectosPorTurno;
	}

	public int getEfectosPorTurno() {
		return efectosPorTurno;
	}

	public void setEfectosPorTurno(int efectosPorTurno) {
		this.efectosPorTurno = efectosPorTurno;
	}

	@Override
	public int visitar(CartaVisitor visitor) {
		return visitor.visitarSupporter(this);
	}

	@Override
	public String formatoArchivo() {
		return nombreCarta + ";" + rareza + ";" + tipo + ";" + efectosPorTurno;
	}
	
	@Override
	public String toString() {
	    return super.toString() +
	           " | Efectos por turno: " + efectosPorTurno;
	}
}
