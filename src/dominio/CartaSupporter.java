package dominio;

public class CartaSupporter extends Carta{
	
	private int efectosPorTurno;
	
	public CartaSupporter(String nombreCarta, int rareza, String tipo, int efectosPorTurno) {
		super(nombreCarta, rareza, "Supporter");
		this.efectosPorTurno = efectosPorTurno;
	}

	public int getEfectosPorTurno() {
		return efectosPorTurno;
	}

	public void setEfectosPorTurno(int efectosPorTurno) {
		this.efectosPorTurno = efectosPorTurno;
	}

}
