package Arbol_Binario;

import java.util.Random;

public class Arbol_Torneo {
        NodoPartido raiz;

        public Arbol_Torneo() {
            raiz = null;
        }


    public NodoPartido crearTorneo(String[] equipos) {
        if (equipos.length != 8) {
            System.out.println("Se necesitan 8 equipos");
            return null;
        }

        NodoPartido q1 = new NodoPartido(equipos[0], equipos[1], "Cuartos");
        NodoPartido q2 = new NodoPartido(equipos[2], equipos[3], "Cuartos");
        NodoPartido q3 = new NodoPartido(equipos[4], equipos[5], "Cuartos");
        NodoPartido q4 = new NodoPartido(equipos[6], equipos[7], "Cuartos");

        NodoPartido s1 = new NodoPartido(null, null, "Semifinal");
        NodoPartido s2 = new NodoPartido(null, null, "Semifinal");

        s1.izquierdo = q1;
        s1.derecho = q2;

        s2.izquierdo = q3;
        s2.derecho = q4;


        NodoPartido finalPartido = new NodoPartido(null, null, "Final");
        finalPartido.izquierdo = s1;
        finalPartido.derecho = s2;

        return finalPartido;
    }
    public void simularTorneo(NodoPartido nodo) {
        if (nodo == null) return;


        simularTorneo(nodo.izquierdo);
        simularTorneo(nodo.derecho);


        if (nodo.equipo1 != null && nodo.equipo2 != null) {
            nodo.ganador = Ganador(nodo.equipo1, nodo.equipo2);
            System.out.println(nodo.ronda + ": " + nodo.equipo1 + " vs " + nodo.equipo2 + " Ganador: " + nodo.ganador);
        } else {
            nodo.equipo1 = nodo.izquierdo.ganador;
            nodo.equipo2 = nodo.derecho.ganador;
            nodo.ganador = Ganador(nodo.equipo1, nodo.equipo2);
            System.out.println(nodo.ronda + ": " + nodo.equipo1 + " vs " + nodo.equipo2 + " Ganador: " + nodo.ganador);
        }
    }
    private String Ganador(String equipo1, String equipo2) {
        Random rand = new Random();
        return rand.nextBoolean() ? equipo1 : equipo2;
    }
    public void mostrarBracket(NodoPartido nodo, int nivel) {
        if (nodo == null) return;

        mostrarBracket(nodo.derecho, nivel + 1);

        for (int i = 0; i < nivel; i++) {
            System.out.print("        ");
        }

        if (nodo.equipo1 != null && nodo.equipo2 != null) {
            System.out.println(nodo.ronda + " [" + nodo.equipo1 + " vs " + nodo.equipo2 + "]");
        } else {
            System.out.println(nodo.ronda);
        }

        mostrarBracket(nodo.izquierdo, nivel + 1);
    }



}

