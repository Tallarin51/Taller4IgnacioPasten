package patrones;

import dominio.*;

public class CartaFactory {
	
	public static Carta crearCarta(String linea) {
        String[] partes = linea.split(";");

        String nombre = partes[0];
        int rareza = Integer.parseInt(partes[1]);
        String tipo = partes[2];

        switch (tipo) {
            case "Pokemon":
                int dano = Integer.parseInt(partes[3]);
                int cantEnergias = Integer.parseInt(partes[4]);
                return new CartaPokemon(nombre, rareza, dano, cantEnergias);

            case "Item":
                int bonificacion = Integer.parseInt(partes[3]);
                return new CartaItem(nombre, rareza, bonificacion);

            case "Supporter":
                int efectosPorTurno = Integer.parseInt(partes[3]);
                return new CartaSupporter(nombre, rareza, efectosPorTurno);

            case "Energy":
                String elemento = partes[3];
                return new CartaEnergy(nombre, rareza, elemento);

            default:
                return null;
        }
    }
	
}
