package com.DuxPrueba.Model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Partido {
	private boolean deuce;
	private boolean tie5;
	private boolean tie6;
	private boolean tieBreak;

	private int cantidadSets;
	private String nombreTorneo;
	private List<Jugador> jugadores;
	
	public boolean isDeuce() {
		return deuce;
	}
	public void setDeuce(boolean deuce) {
		this.deuce = deuce;
	}
	public boolean isTie5() {
		return tie5;
	}
	public void setTie5(boolean tie5) {
		this.tie5 = tie5;
	}
	public boolean isTie6() {
		return tie6;
	}
	public void setTie6(boolean tie6) {
		this.tie6 = tie6;
	}
	public boolean isTieBreak() {
		return tieBreak;
	}
	public void setTieBreak(boolean tieBreak) {
		this.tieBreak = tieBreak;
	}
	public int getCantidadSets() {
		return cantidadSets;
	}
	public void setCantidadSets(int cantidadSets) {
		this.cantidadSets = cantidadSets;
	}

	public String getNombreTorneo() {
		return nombreTorneo;
	}
	public void setNombreTorneo(String nombreTorneo) {
		this.nombreTorneo = nombreTorneo;
	}
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	public Jugador getGanadorPartido(){
		return jugadores.get(0).isGanador() ? jugadores.get(0) : jugadores.get(1); 
	}
	@Override
	public String toString() {
		return "Partido [cantidadSets=" + cantidadSets + ", nombreTorneo=" + nombreTorneo + ", jugadores=" + jugadores+ "]";
	}
}
