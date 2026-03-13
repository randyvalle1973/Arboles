package Arbol_General;

public class Prueba {
    public static void main(String[] args) {
        persona p = new persona("Randy", "2018", 'M');
        persona p2 = new persona("Maria", "1980", 'F');
        persona p3 = new persona("Rolando", "1971", 'M');
        persona p4 = new persona("Roro", "2019", 'F');

        Arbol_Genealogico arbol = new Arbol_Genealogico(p3);
        try {
            arbol.agregarRelacion(arbol.raiz, p3, p, "Hijo");
            arbol.agregarRelacion(arbol.raiz, p3, p2, "Hijo");
            arbol.agregarRelacion(arbol.raiz, p2, p4, "Hijo");
        } catch (Exception e) {
            e.printStackTrace();
        }


//        if (!arbol.eliminar(arbol.raiz, "Randy")) {
//            System.out.println("No se encontró");
//        }
//        arbol.mostrarAntepasados("Randy");
        arbol.BFS();

    }


}
