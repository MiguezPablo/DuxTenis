package com.DuxPrueba.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.DuxPrueba.Logic.SimulacionJuego;
import com.DuxPrueba.Model.Partido;
import com.DuxPrueba.Model.PartidoDTO;
import com.DuxPrueba.Model.Jugador;

@Controller
public class MainController {
	SimulacionJuego sj;
	Partido partido;
	List<Jugador> jugadores;
	
	@GetMapping("/hola")
	public String hola(Model modelo) {
		modelo.addAttribute("mensaje", "hola probando");
		return "hola";
	}

	@GetMapping("/")
	public String home(Model modelo) {
		return "Home";
	}

	@GetMapping("/formulario")
	public String formularioJuego(Model modelo) {
		PartidoDTO partidoDTO = new PartidoDTO();
		modelo.addAttribute("partidoDTO", partidoDTO);
		return "Formulario";
	}
	
	@PostMapping("/formulario")
	public String submitForm(@ModelAttribute PartidoDTO partidoDTO) {
		partido = new Partido();
		partido.setNombreTorneo(partidoDTO.getNombreTorneo());
		partido.setCantidadSets(Integer.parseInt(partidoDTO.getCantidadSet()));
		
		Jugador jugador1 = new Jugador();
		jugador1.setNombre(partidoDTO.getNombreJugador1());
		jugador1.setPuntosHabilidad(Integer.parseInt(partidoDTO.getHabilidadJ1()));
		
		Jugador jugador2 = new Jugador();
		jugador2.setNombre(partidoDTO.getNombreJugador2());
		jugador2.setPuntosHabilidad(100 - (jugador1.getPuntosHabilidad()));
		
		jugadores = new ArrayList<>();
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		partido.setJugadores(jugadores);

		return "redirect:/juego";
	}
	
	@GetMapping("/juego")
	public String comenzarJuego(Model modelo) {
		sj = new SimulacionJuego(partido);
		modelo.addAttribute("nombreTorneo", partido.getNombreTorneo());
		modelo.addAttribute("Jugador1", partido.getJugadores().get(0));
		modelo.addAttribute("Jugador2", partido.getJugadores().get(1));
		modelo.addAttribute("finalizado", sj.getPartidoFinalidado());
		sj.simulacion();
		return "Juego";
	}
	
	@RequestMapping(value="/event-count", method=RequestMethod.GET)
	public String getEventCount(ModelMap map) {
	    map.addAttribute("Jugador1", partido.getJugadores().get(0));
	    map.addAttribute("Jugador2", partido.getJugadores().get(1));
	    map.addAttribute("finalizado", sj.getPartidoFinalidado());
	    return "Juego :: #eventCount";
	}
	
	@RequestMapping(value="/finalizado", method=RequestMethod.GET)
	public String getFinalizado(ModelMap map) {
	    map.addAttribute("finalizado", sj.getPartidoFinalidado());
	    return "Juego :: #finished";
	}
	
	@GetMapping("/resultado")
	public String obtenerResultado(Model modelo) {
		modelo.addAttribute("partido", partido);
		modelo.addAttribute("setsJ1", partido.getJugadores().get(0).getSets());
		modelo.addAttribute("setsJ2", partido.getJugadores().get(1).getSets());
		return "Resultado";
	}
}
