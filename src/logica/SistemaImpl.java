package logica;

import java.util.ArrayList;
import java.io.*;
import dominio.Carta;
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
		
		
		
		return false;
	}

	@Override
	public boolean modificarCarta(String nombreCarta, String nuevoValor1, String nuevoValor2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Carta> obtenerCartas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEstrategiaOrdenamiento(StrategyOrdenamiento estrategia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ordenarCartas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cargarCartasDesdeArchivo(String rutaArchivo) {
		// TODO Auto-generated method stub
		
	}

}
