package patrones;

import dominio.CartaEnergy;
import dominio.CartaItem;
import dominio.CartaPokemon;
import dominio.CartaSupporter;

public class CalcularPoderVisitor implements CartaVisitor {

	@Override
	public int visitarPokemon(CartaPokemon carta) {
		if (carta.getCantEnergias() == 0) {
			return 0;
		}
		
		return (carta.getDaño() / carta.getCantEnergias()) * 100;
	}

	@Override
	public int visitarItem(CartaItem carta) {
		return carta.getBonificacion() * 20;
	}

	@Override
	public int visitarSupporter(CartaSupporter carta) {
		return (carta.getEfectosPorTurno() * 50);
	}

	@Override
	public int visitarEnergy(CartaEnergy carta) {
		return 1;
	}

}
