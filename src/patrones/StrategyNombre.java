package patrones;

import java.util.ArrayList;

import dominio.Carta;

public class StrategyNombre implements StrategyOrdenamiento {

	@Override
	public void ordenar(ArrayList<Carta> cartas) {
		for (int i = 0; i < cartas.size() - 1; i++) {
            for (int j = i + 1; j < cartas.size(); j++) {

                String nombre1 = cartas.get(i).getNombreCarta();
                String nombre2 = cartas.get(j).getNombreCarta();

                if (nombre1.compareToIgnoreCase(nombre2) > 0) {
                    Carta aux = cartas.get(i);
                    cartas.set(i, cartas.get(j));
                    cartas.set(j, aux);
                }
            }
        }
	}

}
