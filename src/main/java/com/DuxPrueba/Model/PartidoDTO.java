package com.DuxPrueba.Model;

public class PartidoDTO {
	private String nombreTorneo;
	private String nombreJugador1;
	private String nombreJugador2;
	private String habilidadJ1;
	private String habilidadJ2;
	private String cantidadSet;
	public String getNombreTorneo() {
		return nombreTorneo;
	}
	public void setNombreTorneo(String nombreTorneo) {
		this.nombreTorneo = nombreTorneo;
	}
	public String getNombreJugador1() {
		return nombreJugador1;
	}
	public void setNombreJugador1(String nombreJugador1) {
		this.nombreJugador1 = nombreJugador1;
	}
	public String getNombreJugador2() {
		return nombreJugador2;
	}
	public void setNombreJugador2(String nombreJugador2) {
		this.nombreJugador2 = nombreJugador2;
	}
	public String getHabilidadJ1() {
		return habilidadJ1;
	}
	public void setHabilidadJ1(String habilidadJ1) {
		this.habilidadJ1 = habilidadJ1;
	}
	public String getHabilidadJ2() {
		return habilidadJ2;
	}
	public void setHabilidadJ2(String habilidadJ2) {
		this.habilidadJ2 = habilidadJ2;
	}
	public String getCantidadSet() {
		return cantidadSet;
	}
	public void setCantidadSet(String cantidadSet) {
		this.cantidadSet = cantidadSet;
	}
	@Override
	public String toString() {
		return "PartidoDTO [nombreTorneo=" + nombreTorneo + ", nombreJugador1=" + nombreJugador1 + ", nombreJugador2="
				+ nombreJugador2 + ", habilidadJ1=" + habilidadJ1 + ", habilidadJ2=" + habilidadJ2 + ", cantidadSet="
				+ cantidadSet + "]";
	}

	
	
}
