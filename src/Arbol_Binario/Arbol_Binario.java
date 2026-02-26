package Arbol_Binario;

public class Arbol_Binario {
        Nodo_Arbol raiz;

        public Arbol_Binario() {
            raiz = null;
        }

    public void insertar(int e) {
        raiz = insertarRecursivo(raiz, e);
    }

    private Nodo_Arbol insertarRecursivo(Nodo_Arbol actual, int valor) {

        if (actual == null) {
            return new Nodo_Arbol(valor);
        }

        if (valor < actual.valor) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, valor);
        } else if (valor > actual.valor) {
            actual.derecho = insertarRecursivo(actual.derecho, valor);
        }

        return actual;
    }

    public Nodo_Arbol getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo_Arbol raiz) {
        this.raiz = raiz;
    }
}

