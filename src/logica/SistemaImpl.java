package logica;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import dominio.*;
import patrones.CartaFactory;
import patrones.StrategyOrdenamiento;

public class SistemaImpl implements Sistema{
	
	private static Sistema instancia;
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
		}
		
		
		return false;
	}

	@Override
	public boolean modificarCarta(String nombreCarta, String valor1, String valor2) {
		for (int i = 0; i < cartas.size(); i++) {
	        Carta carta = cartas.get(i);

	        if (carta.getNombreCarta().equalsIgnoreCase(nombreCarta)) {

	            if (carta instanceof CartaPokemon) {
	                CartaPokemon pokemon = (CartaPokemon) carta;
	                int nuevoDano = Integer.parseInt(valor1);
	                int nuevaCantEnergias = Integer.parseInt(valor2);

	                pokemon.setDaño(nuevoDano);
	                pokemon.setCantEnergias(nuevaCantEnergias);
	                
	                guardarCartasEnArchivo("Sobres.txt");
	                return true;
	            }

	            if (carta instanceof CartaItem) {
	                CartaItem item = (CartaItem) carta;

	                int nuevaBonificacion = Integer.parseInt(valor1);
	                item.setBonificacion(nuevaBonificacion);
	                
	                guardarCartasEnArchivo("Sobres.txt");
	                return true;
	            }

	            if (carta instanceof CartaSupporter) {
	                CartaSupporter supporter = (CartaSupporter) carta;

	                int nuevosEfectos = Integer.parseInt(valor1);
	                supporter.setEfectosPorTurno(nuevosEfectos);
	                
	                guardarCartasEnArchivo("Sobres.txt");
	                return true;
	            }

	            if (carta instanceof CartaEnergy) {
	                CartaEnergy energy = (CartaEnergy) carta;

	                energy.setElemento(valor1);
	                
	                guardarCartasEnArchivo("Sobres.txt");
	                return true;
	            }
	        }
	    }

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
