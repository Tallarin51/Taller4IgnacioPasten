package patrones;

import java.util.ArrayList;

import dominio.Carta;

public class StrategyRareza implements StrategyOrdenamiento {

	@Override
	public void ordenar(ArrayList<Carta> cartas) {
		
	       for (int i = 0; i < cartas.size() - 1; i++) {
	           for (int j = i + 1; j < cartas.size(); j++) {
	               if (cartas.get(i).getRareza() < cartas.get(j).getRareza()) {
	                    Carta aux = cartas.get(i);
	                    cartas.set(i, cartas.get(j));
	                    cartas.set(j, aux);
	                }
	            }
	        }
	    }

}
