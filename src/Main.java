import com.sam.equipo.Equipo;
import com.sam.exceptions.EquipoException;
import com.sam.jugador.Jugador;
import com.sam.jugador.PosicionJugadores;

public class Main {
    public static void main(String[] args) throws EquipoException {

        Equipo equipo = new Equipo("Barcelona");
//        System.out.println(equipo.posicionesValidas("DELANT"));

        equipo.agregarJugador(new Jugador("Leonel Messi", "DELANTERO", 10, "RESeRVADO"));
        equipo.agregarJugador(new Jugador("Ronaldinho", "DELANTERO", 11, "TITULAR"));
        equipo.agregarJugador(new Jugador("Maschrerano", "DEFENSOR", 3, "TITULAR"));
        equipo.agregarJugador(new Jugador("Andres Pirlo", "Mediocampista", 5, "SUPLENTE"));
        equipo.agregarJugador(new Jugador("Buffon", "Arquero", 1, "RESeRVADo"));
        equipo.agregarJugador(new Jugador("Dani ALves", "DEFENSOR", 4, "SUPLENTE"));

        try {
            System.out.println(equipo.cantidadJugadores("mediocampista"));
        } catch (EquipoException e) {
            e.printStackTrace();
        }

        System.out.println("Reserva: ");
        for (Jugador jugador : equipo.mostrarReserva()) {
            System.out.println("Jugador: " + jugador.toString());
        }

        System.out.println("Jugador 4: " + equipo.buscarJugadorer(4));
        System.out.println(equipo.buscarJugadorer(7));
    }
}