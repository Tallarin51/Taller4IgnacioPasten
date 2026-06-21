package patrones;

import java.util.ArrayList;

import dominio.Carta;

public class StrategyPoder implements StrategyOrdenamiento  {

	@Override
	public void ordenar(ArrayList<Carta> cartas) {
		
		 CalcularPoderVisitor visitor = new CalcularPoderVisitor();
		
		 for (int i = 0; i < cartas.size() - 1; i++) {
			 for (int j = i + 1; j < cartas.size(); j++) {
				 
				 int poder1 = cartas.get(i).visitar(visitor);
				 int poder2 = cartas.get(j).visitar(visitor);
				 
				 if (poder1 < poder2) {
					 Carta aux = cartas.get(i);
					 cartas.set(i, cartas.get(j));
					 cartas.set(j, aux);
				 }
				 
			 }
		 }
		 
	}

}
