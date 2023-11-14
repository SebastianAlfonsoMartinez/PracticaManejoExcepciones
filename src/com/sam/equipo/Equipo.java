package com.sam.equipo;

import com.sam.exceptions.EquipoException;
import com.sam.jugador.Jugador;
import com.sam.jugador.PosicionJugadores;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;


public class Equipo {

    private String nombre;
    private HashSet<Jugador>  listaJugadores ;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.listaJugadores = new HashSet<Jugador>();
    }

    public void agregarJugador(Jugador jugador){
        listaJugadores.add(jugador);
    }
    public Integer cantidadJugadores(String posicion) throws EquipoException {
        List<String> posicionesValidas = posicionesValidas();

        // Convierte la posición ingresada a mayúsculas
        String posicionUpperCase = posicion.toUpperCase();

        if (!posicionesValidas.contains(posicionUpperCase)) {
            throw new EquipoException(posicion + " No es una posición válida");
        }

        Integer jugadoresEnPosicion = 0;

        for (Jugador jugador : listaJugadores) {
            // Convierte la posición del jugador a mayúsculas
            String jugadorPosicionUpperCase = jugador.getPosicion().toUpperCase();

            if (jugadorPosicionUpperCase.equals(posicionUpperCase)) {
                jugadoresEnPosicion++;
            }
        }

        System.out.println("Posición buscada: " + posicion);
        System.out.println("Número de jugadores en la posición: " + jugadoresEnPosicion);

        return jugadoresEnPosicion;
    }


    private List<String> posicionesValidas () {
        List<String> posicionesValidas = new ArrayList<>();
        for (PosicionJugadores posicionJugadores : PosicionJugadores.values()) {
                posicionesValidas.add(posicionJugadores.name());
        }
        return posicionesValidas;
    }

    public List<Jugador> mostrarReserva(){
        List<Jugador> reserva = new ArrayList<>();

        for (Jugador jugador : listaJugadores) {
            if (jugador.getEstado().equalsIgnoreCase("RESERVADO"))
                reserva.add(jugador);
        }
        return reserva;
    }

    public Jugador buscarJugadorer (Integer numeroJugador) throws EquipoException {
        Optional<Jugador> jugador = listaJugadores.stream().filter(gamer -> gamer.getNumCamiseta().
                equals(numeroJugador)).findAny();
        if (jugador.isEmpty())
            throw new EquipoException("El jugador numero " + numeroJugador + " no existe");
        else
            return jugador.get();
    }
}
