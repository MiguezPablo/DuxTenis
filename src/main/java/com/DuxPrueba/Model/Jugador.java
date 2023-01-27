package com.DuxPrueba.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Jugador {
	private boolean saque;
	private boolean ganador;

	private int puntosHabilidad;
	private int setsGanados;
	private int puntosJuego;
	private int juegosGanados;

	private String nombre;
	private List<Integer> sets = new ArrayList<Integer>();
	
	public boolean isSaque() {
		return saque;
	}

	public void setSaque(boolean saque) {
		this.saque = saque;
	}

	public boolean isGanador() {
		return ganador;
	}

	public void setGanador(boolean ganador) {
		this.ganador = ganador;
	}

	public int getPuntosHabilidad() {
		return puntosHabilidad;
	}

	public void setPuntosHabilidad(int puntosHabilidad) {
		this.puntosHabilidad = puntosHabilidad;
	}

	public int getSetsGanados() {
		return setsGanados;
	}

	public void setSetsGanados(int setsGanados) {
		this.setsGanados = setsGanados;
	}

	public int getPuntosJuego() {
		return puntosJuego;
	}

	public void setPuntosJuego(int puntosJuego) {
		this.puntosJuego = puntosJuego;
	}

	public int getJuegosGanados() {
		return juegosGanados;
	}

	public void setJuegosGanados(int juegosGanados) {
		this.juegosGanados = juegosGanados;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSets(Integer puntos) {
		if(puntos == -1) {
			sets = new ArrayList<Integer>();
		}
		else {
			sets.add(puntos);
		}
	}

	public List<Integer> getSets() {
		return sets;
	}

	@Override
	public String toString() {
		return "Jugador [saque=" + saque + ", ganador=" + ganador + ", puntosHabilidad=" + puntosHabilidad
				+ ", setsGanados=" + setsGanados + ", puntosJuego=" + puntosJuego + ", juegosGanados=" + juegosGanados
				+ ", nombre=" + nombre + ", sets=" + sets + "]";
	}
}
