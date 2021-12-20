package com.company.entidades;

public class Tablero {
    private Celda[] celdas;
    private ColeccionCeldas[] grupoDeCeldas;
    private int turnoJugador; // 1 o 2

    public Tablero() {
        this.celdas = new Celda[9];
        for (int i=0;i<9;i++) this.celdas[i] = new Celda();
        this.grupoDeCeldas = new ColeccionCeldas[8];
        // fila superior
        this.grupoDeCeldas[0] = new ColeccionCeldas(this.celdas, 0, 1, 2);
        // fila central
        this.grupoDeCeldas[1] = new ColeccionCeldas(this.celdas, 3, 4, 5);
        // fila inferior
        this.grupoDeCeldas[2] = new ColeccionCeldas(this.celdas, 6, 7, 8);
        // columna izquierda
        this.grupoDeCeldas[3] = new ColeccionCeldas(this.celdas, 0, 3, 6);
        // columna central
        this.grupoDeCeldas[4] = new ColeccionCeldas(this.celdas, 1, 4, 7);
        // columna derecha
        this.grupoDeCeldas[5] = new ColeccionCeldas(this.celdas, 2, 5, 8);
        // diagonal \
        this.grupoDeCeldas[6] = new ColeccionCeldas(this.celdas, 0, 4, 8);
        // diagonal /
        this.grupoDeCeldas[7] = new ColeccionCeldas(this.celdas, 6, 4, 2);

        this.turnoJugador = 1;
    }

    // deberia llamarse cada vez que un jugador juega
    public int ganaJugador() { // 0 si no gana nadie todavia
        for (ColeccionCeldas celdas: this.grupoDeCeldas) {
            if (celdas.todasContienen(1)) return 1;
            if (celdas.todasContienen(2)) return 2;
        }
        return 0;
    }

    public void jugarCelda(int numeroDeJugador, int numeroDeCelda) {
        if (this.celdas[numeroDeCelda].estaLibre()) {
            this.celdas[numeroDeCelda].actualizarContenido(numeroDeJugador);
            avanzarTurnoJugador();
        }
    }

    public void jugarCeldaSiguienteJugador(int numeroDeCelda) {
        jugarCelda(this.turnoJugador, numeroDeCelda);
    }

    private void avanzarTurnoJugador() {
        this.turnoJugador = this.turnoJugador == 1 ? 2 : 1;
    }
}


