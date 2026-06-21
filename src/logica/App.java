package logica;

import dominio.*;
import patrones.*;


public class App {

	public static void main(String[] args) {
		
		Sistema sistema = SistemaImpl.getInstancia();

        sistema.cargarCartasDesdeArchivo("Sobres.txt");

        System.out.println("=== CARTAS CARGADAS ===");
        mostrarCartas(sistema);

        System.out.println("=== ORDENADAS POR RAREZA ===");
        sistema.setEstrategiaOrdenamiento(new StrategyRareza());
        sistema.ordenarCartas();
        mostrarCartas(sistema);

        System.out.println("=== ORDENADAS POR NOMBRE ===");
        sistema.setEstrategiaOrdenamiento(new StrategyNombre());
        sistema.ordenarCartas();
        mostrarCartas(sistema);

        System.out.println("=== ORDENADAS POR PODER ===");
        sistema.setEstrategiaOrdenamiento(new StrategyPoder());
        sistema.ordenarCartas();
        mostrarCartas(sistema);

        System.out.println("=== MODIFICAR CARTA ===");
        boolean modificada = sistema.modificarCarta("Mega Charizard-Ex", "300", "3");
        System.out.println("Modificada: " + modificada);

        System.out.println("=== ELIMINAR CARTA ===");
        boolean eliminada = sistema.eliminarCarta("Pikachu");
        System.out.println("Eliminada: " + eliminada);

        sistema.guardarCartasEnArchivo("Sobres.txt");

        System.out.println("=== CARTAS FINALES ===");
        mostrarCartas(sistema);
    }

    public static void mostrarCartas(Sistema sistema) {
        CalcularPoderVisitor visitor = new CalcularPoderVisitor();

        for (Carta carta : sistema.obtenerCartas()) {
            System.out.println(carta);
            System.out.println("Poder: " + carta.visitar(visitor));
            System.out.println("----------------------");
        }
    }

}
