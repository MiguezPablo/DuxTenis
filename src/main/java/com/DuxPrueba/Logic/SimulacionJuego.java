package com.DuxPrueba.Logic;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

import javax.swing.Timer;

import java.util.stream.Collectors;
import com.DuxPrueba.Model.Jugador;
import com.DuxPrueba.Model.Partido;

public class SimulacionJuego {
	private static final int PUNTOS_DEUCE = 40; 
	private static final int JUEGOS_PARA_GANAR = 6;
	private static final int PUNTOS_PARA_GANAR = 40;

	private static final int TIEMPO_DELAY = 500;

	private boolean partidoFinalizado;
	private int juegosRestantes;
	private Partido partido;
	private Random generadorRandom;
	private Timer timer;

	public SimulacionJuego(Partido partido) {
		this.partido = partido;
		partido.getJugadores().get(0).setSetsGanados(0);
		partido.getJugadores().get(1).setSetsGanados(0);
		partido.getJugadores().get(0).setSets(-1);
		partido.getJugadores().get(1).setSets(-1);
		juegosRestantes = JUEGOS_PARA_GANAR;
		partidoFinalizado = false;
		generadorRandom = new Random();
	}

	public boolean getPartidoFinalidado() {
		return partidoFinalizado;
	}

	public void  simulacion() {
		jugadorSaque(true);

		timer = new Timer(TIEMPO_DELAY, null);

		timer.addActionListener(e -> {
			generadorPuntos();
			System.out.println(partido);
		});
		timer.setRepeats(true);
		timer.start();
	}

	private void jugadorSaque(boolean primeraVez) {
		if (primeraVez) {
			int SaqueIndex = generadorRandom.nextInt(2);

			partido.getJugadores()
			.get(SaqueIndex)
			.setSaque(true);

			partido.getJugadores()
			.get(1 - SaqueIndex)
			.setSaque(false);
		} else {
			Jugador ultimoSaque = partido.getJugadores()
					.stream()
					.filter(Jugador::isSaque)
					.collect(Collectors.toList())
					.get(0);

			Jugador nuevoSaque = partido.getJugadores()
					.get(1 - partido.getJugadores()
							.indexOf(ultimoSaque));

			ultimoSaque.setSaque(false);
			nuevoSaque.setSaque(true);
		}
	}

	private void generadorPuntos() {
		Jugador Jugador1 = partido.getJugadores()
				.get((generadorRandom.nextDouble()
						<= (double) partido.getJugadores()
						.get(0)
						.getPuntosHabilidad() / 100) ? 0 : 1);

		int puntosJugador;

		if (partido.isDeuce()) {
			puntosJugador = Jugador1.getPuntosJuego() + 1;
		} 
		else {
			puntosJugador =  Jugador1.getPuntosJuego() + 15;
			if (puntosJugador == 45) {
				puntosJugador = 40;
			}
		}

		Jugador1.setPuntosJuego(puntosJugador);

		Jugador Jugador2 = partido.getJugadores()
				.get(1 - partido.getJugadores()
						.indexOf(Jugador1));

		if (checkEmpate(Jugador1.getPuntosJuego(), Jugador2.getPuntosJuego(), PUNTOS_DEUCE)) {
			partido.setDeuce(true);
		}

		if (partido.isDeuce() && Jugador1.getPuntosJuego() == Jugador2.getPuntosJuego() + 2) {
			partido.setDeuce(false);
			jugadorGanadorJuego(Jugador1, Jugador2);
			return;
		}

		if (!partido.isDeuce() && Jugador1.getPuntosJuego() > PUNTOS_PARA_GANAR) {
			jugadorGanadorJuego(Jugador1, Jugador2);
			return;
		}
	}

	private void jugadorGanadorJuego(Jugador Jugador1, Jugador Jugador2) {
		Jugador1.setPuntosJuego(0);
		Jugador2.setPuntosJuego(0);

		int juegosGanados = Jugador1.getJuegosGanados() + 1;

		Jugador1.setJuegosGanados(juegosGanados);

		if (checkEmpate(Jugador1.getJuegosGanados(), Jugador2.getJuegosGanados(), JUEGOS_PARA_GANAR - 1)) {
			partido.setTie5(true);

			juegosRestantes = JUEGOS_PARA_GANAR + 1;
		}

		if (checkEmpate(Jugador1.getJuegosGanados(), Jugador2.getJuegosGanados(), JUEGOS_PARA_GANAR)) {
			partido.setTie5(false);
			partido.setTie6(true);

			juegosRestantes = JUEGOS_PARA_GANAR + 7;
		}

		if (partido.isTieBreak() && Jugador1.getPuntosJuego() == Jugador2.getPuntosJuego() + 2) {
			jugadorGanadorSet(Jugador1, Jugador2);
			return;
		}

		if (Jugador1.getJuegosGanados() == juegosRestantes) {
			if (checkEmpate(Jugador1.getJuegosGanados(), Jugador2.getJuegosGanados(), juegosRestantes)) {
				partido.setTieBreak(true);
			}

			jugadorGanadorSet(Jugador1, Jugador2);
			return;
		}
	}


	private void jugadorGanadorSet(Jugador jugador1, Jugador jugador2) {
		jugador1.setSets(jugador1.getJuegosGanados());
		jugador2.setSets(jugador2.getJuegosGanados());
		jugador1.setJuegosGanados(0);
		jugador2.setJuegosGanados(0);

		int setsGanados = jugador1.getSetsGanados() + 1;

		jugador1.setSetsGanados(setsGanados);

		if (partidoTerminado(jugador1, jugador2)) {
			timer.stop();

			if (partido.getCantidadSets() != jugador1.getSetsGanados() + jugador2.getSetsGanados()) {
				partido.setCantidadSets(jugador1.getSetsGanados());
			}

			jugador1.setGanador(true);

			partidoFinalizado = true;

			return;
		}

		if (partido.isTie5() || partido.isTie6()) {
			partido.setTie5(false);
			partido.setTie6(false);
			partido.setTieBreak(false);

			juegosRestantes = JUEGOS_PARA_GANAR;
		}

		jugadorSaque(false);
	}

	private boolean partidoTerminado(Jugador Jugador1, Jugador Jugador2) {
		return Jugador1.getSetsGanados()+ Jugador2.getSetsGanados() == partido.getCantidadSets()
				|| (Jugador1.getSetsGanados() > partido.getCantidadSets() / 2
						&& partido.getCantidadSets() - Jugador1.getSetsGanados()
						< partido.getCantidadSets() - Jugador2.getSetsGanados());
	}


	private boolean checkEmpate(int puntosJugador1, int puntosJugador2, int puntosReferencia) {
		return puntosJugador1 == puntosReferencia && puntosJugador1 == puntosJugador2;
	}

}
