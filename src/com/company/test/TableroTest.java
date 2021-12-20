package com.company.test;

import com.company.entidades.Tablero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TableroTest {
    private Tablero tablero;

    @BeforeEach
    public void SetUp() {
        this.tablero = new Tablero();
    }

    @Test
    public void TableroNuevoNoGanaNadie() {
        int jugadorGanador = this.tablero.ganaJugador();
        assertEquals(jugadorGanador, 0);
    }

    @Test
    public void Jugador1JuegaVariasVecesPeroSinGanar() {
        this.tablero.jugarCelda(1,0);
        this.tablero.jugarCelda(1,4);
        this.tablero.jugarCelda(1,1);
        this.tablero.jugarCelda(1,3);
        assertEquals(this.tablero.ganaJugador(), 0);
    }

    @Test
    public void JugadoresJueganEnOrdenPeroNoGanaNadie() {
        this.tablero.jugarCeldaSiguienteJugador(0);
        this.tablero.jugarCeldaSiguienteJugador(4);
        this.tablero.jugarCeldaSiguienteJugador(1);
        this.tablero.jugarCeldaSiguienteJugador(3);
        assertEquals(this.tablero.ganaJugador(), 0);
    }

    @Test
    public void JugadoresJueganEnOrdenYGanaJugador1() {
        this.tablero.jugarCeldaSiguienteJugador(0);
        this.tablero.jugarCeldaSiguienteJugador(4);
        this.tablero.jugarCeldaSiguienteJugador(1);
        this.tablero.jugarCeldaSiguienteJugador(3);
        this.tablero.jugarCeldaSiguienteJugador(2);
        assertEquals(this.tablero.ganaJugador(), 1);
    }

    @Test
    public void JugadoresJueganEnOrdenYGanaJugador2() {
        this.tablero.jugarCeldaSiguienteJugador(0);
        this.tablero.jugarCeldaSiguienteJugador(4);
        this.tablero.jugarCeldaSiguienteJugador(1);
        this.tablero.jugarCeldaSiguienteJugador(3);
        this.tablero.jugarCeldaSiguienteJugador(6);
        this.tablero.jugarCeldaSiguienteJugador(5);
        assertEquals(this.tablero.ganaJugador(), 2);
    }

    @Test
    public void GanaPorPrimeraFila() {
        for (int i=0;i<3;i++) {
            this.tablero.jugarCelda(1,i);
        }
        assertEquals(this.tablero.ganaJugador(), 1);
    }

    @Test
    public void GanaPorSegundaFila() {
        for (int i=0;i<3;i++) {
            this.tablero.jugarCelda(1,i+3);
        }
        assertEquals(this.tablero.ganaJugador(), 1);
    }

    @Test
    public void GanaPorTerceraFila() {
        for (int i=0;i<3;i++) {
            this.tablero.jugarCelda(1,i+6);
        }
        assertEquals(this.tablero.ganaJugador(), 1);
    }

    @Test
    public void GanaPorPrimeraColumna() {
        for (int i=0;i<3;i++) {
            this.tablero.jugarCelda(1,i*3);
        }
        assertEquals(this.tablero.ganaJugador(), 1);
    }

    @Test
    public void GanaPorSegundaColumna() {
        for (int i=0;i<3;i++) {
            this.tablero.jugarCelda(1,i*3 + 1);
        }
        assertEquals(this.tablero.ganaJugador(), 1);
    }

    @Test
    public void GanaPorTerceraColumna() {
        for (int i=0;i<3;i++) {
            this.tablero.jugarCelda(1,i*3 + 2);
        }
        assertEquals(this.tablero.ganaJugador(), 1);
    }

    @Test
    public void GanaPorPrimeraDiagonal() {
        for (int i=0;i<3;i++) {
            this.tablero.jugarCelda(1,i*3 + i);
        }
        assertEquals(this.tablero.ganaJugador(), 1);
    }

    @Test
    public void GanaPorSegundaDiagonal() {
        for (int i=0;i<3;i++) {
            this.tablero.jugarCelda(1,(i+1)*2);
        }
        assertEquals(this.tablero.ganaJugador(), 1);
    }
}
