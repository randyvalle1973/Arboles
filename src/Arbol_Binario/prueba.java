package Arbol_Binario;
public class prueba {
    public static void main(String[] args) {
        String[] equipos = {
                "Madrid", "Barca", "City", "PSG",
                "Bayern", "Inter", "Liverpool", "Dortmund"
        };

        Arbol_Torneo torneo = new Arbol_Torneo();
        torneo.raiz = torneo.crearTorneo(equipos);
        torneo.simularTorneo(torneo.raiz);
        System.out.println(torneo.raiz.ganador);
        torneo.mostrarBracket(torneo.raiz, 0);
    }

}
