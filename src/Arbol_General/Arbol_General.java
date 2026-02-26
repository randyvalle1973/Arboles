package Arbol_General;

public class Arbol_General {
    Nodo_ArbolG raiz;

    public Arbol_General(int datoRaiz) {
        raiz = new Nodo_ArbolG(datoRaiz);
    }

    public void insertarHijo(Nodo_ArbolG padre, int datoHijo) {
        Nodo_ArbolG nuevo = new Nodo_ArbolG(datoHijo);
        padre.hijos.add(nuevo);
    }

    public Nodo_ArbolG getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo_ArbolG raiz) {
        this.raiz = raiz;
    }
}
