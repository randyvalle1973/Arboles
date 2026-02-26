package Arbol_General;

import java.util.ArrayList;
import java.util.List;

public class Nodo_ArbolG {
    int dato;
    List<Nodo_ArbolG> hijos;

    public Nodo_ArbolG(int dato) {
        this.dato = dato;
        this.hijos = new ArrayList<>();
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public List<Nodo_ArbolG> getHijos() {
        return hijos;
    }

    public void setHijos(List<Nodo_ArbolG> hijos) {
        this.hijos = hijos;
    }
}
