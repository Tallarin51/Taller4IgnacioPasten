package logica;

import java.util.ArrayList;
import dominio.Carta;
import patrones.*;

public interface Sistema {
	
	void agregarCarta(Carta carta);
	
	boolean eliminarCarta(String nombreCarta);

    boolean modificarCarta(String nombreCarta, String nuevoValor1, String nuevoValor2);

    ArrayList<Carta> obtenerCartas();

    void setEstrategiaOrdenamiento(StrategyOrdenamiento estrategia);

    void ordenarCartas();

    void cargarCartasDesdeArchivo(String rutaArchivo);
	
}
