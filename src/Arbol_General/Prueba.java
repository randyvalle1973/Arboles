package Arbol_General;

public class Prueba {
    public static void main(String[] args) {
        Arbol_General arbol = new Arbol_General(1);
        try {
            arbol.insertarHijo(arbol.raiz, 2);
            arbol.insertarHijo(arbol.raiz, 3);
            arbol.insertarHijo(arbol.raiz, 5);
            arbol.insertarHijo(arbol.raiz, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        arbol.eliminar(arbol.raiz, 7);
        arbol.preorden(arbol.raiz);
        System.out.println("\n");
        arbol.postorden(arbol.raiz);

    }


}
