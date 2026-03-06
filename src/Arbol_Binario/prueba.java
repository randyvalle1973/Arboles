package Arbol_Binario;
public class prueba {
    public static void main(String[] args) {

        Arbol_Binario arbol = new Arbol_Binario();
        try {
            arbol.insertar(8);
            arbol.insertar(3);
            arbol.insertar(10);
            arbol.insertar(1);
            arbol.insertar(6);
        } catch (Exception e) {
            e.printStackTrace();
        }
        arbol.preorden();
        System.out.println("\n");
        arbol.entreorden();
        System.out.println("\n");
        arbol.postorden();
    }
}
