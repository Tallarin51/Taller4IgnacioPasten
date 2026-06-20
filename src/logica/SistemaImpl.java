package logica;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import dominio.Carta;
import patrones.CartaFactory;
import patrones.StrategyOrdenamiento;

public class SistemaImpl implements Sistema{
	
	private static Sistema instancia = null;
	private ArrayList<Carta> cartas = new ArrayList<Carta>();
	private StrategyOrdenamiento estrategia;
	
	private SistemaImpl() {
	}
	
	public static Sistema getInstancia() {
		
		if (instancia == null) {
			instancia = new SistemaImpl();
		}
		return instancia;
	}
	
	@Override
	public void agregarCarta(Carta carta) {
		
		if (carta != null) {
			cartas.add(carta);
		}
		
	}

	@Override
	public boolean eliminarCarta(String nombreCarta) {
		for (int i = 0; i < cartas.size(); i++) {
			Carta carta = cartas.get(i);
			
			if (carta.getNombreCarta().equalsIgnoreCase(nombreCarta)) {
				cartas.remove(i);
				return true;
			}
			return false;
		}
		
		
		return false;
	}

	@Override
	public boolean modificarCarta(String nombreCarta, String nuevoValor1, String nuevoValor2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Carta> obtenerCartas() {
		return cartas;
	}

	@Override
	public void setEstrategiaOrdenamiento(StrategyOrdenamiento estrategia) {
		this.estrategia = estrategia;
	}

	@Override
	public void ordenarCartas() {
		if (estrategia != null) {
			estrategia.ordenar(cartas);
		}
	}

	@Override
	public void cargarCartasDesdeArchivo(String nombreArchivo) {
		
		try {
			File f = new File(nombreArchivo);
			Scanner sc = new Scanner(f);
			
			while (sc.hasNextLine()) {
				
				String linea = sc.nextLine();
				Carta carta = CartaFactory.crearCarta(linea);
				agregarCarta(carta);
				
			}
			
			sc.close();
			
		} catch (IOException e) {
			System.out.println("Error al cargar el archivo.");
		}
		
	}

	@Override
	public void guardarCartasEnArchivo(String rutaArchivo) {
		
		try {
	        FileWriter escritor = new FileWriter(rutaArchivo);

	        for (int i = 0; i < cartas.size(); i++) {
	            Carta carta = cartas.get(i);
	            escritor.write(carta.formatoArchivo() + "\n");
	        }

	        escritor.close();

	    } catch (Exception e) {
	        System.out.println("Error al guardar cartas: " + e.getMessage());
	    }
		
	}

}
