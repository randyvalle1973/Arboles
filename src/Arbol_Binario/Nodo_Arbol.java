package Arbol_Binario;

public class Nodo_Arbol {
        int valor;
        Nodo_Arbol izquierdo;
        Nodo_Arbol derecho;

        public Nodo_Arbol(int valor) {
            this.valor = valor;
            this.izquierdo = null;
            this.derecho = null;
        }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo_Arbol getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo_Arbol izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo_Arbol getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo_Arbol derecho) {
        this.derecho = derecho;
    }
}
