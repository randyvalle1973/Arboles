package Arbol_Binario;

public class Arbol_Binario {
        Nodo_Arbol raiz;

        public Arbol_Binario() {
            raiz = null;
        }

    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
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
    public void eliminar(int e) {
        raiz = eliminarnodo(raiz, e);
    }

    private Nodo_Arbol eliminarnodo(Nodo_Arbol actual, int valor) {
        if (actual == null) {
            return null;
        }

        if (valor < actual.valor) {
            actual.izquierdo = eliminarnodo(actual.izquierdo, valor);
        }
        else if (valor > actual.valor) {
            actual.derecho = eliminarnodo(actual.derecho, valor);
        }
        else {
            if (actual.izquierdo == null && actual.derecho == null) {
                System.out.println("Nodo con valor " + valor + " eliminado ");
                return null;
            }
            if (actual.izquierdo == null) {
                System.out.println("Nodo con valor " + valor + " eliminado");
                return actual.derecho;

            }
            if (actual.derecho == null) {
                System.out.println("Nodo con valor " + valor + " eliminado");
                return actual.izquierdo;
            }

            int sucesor = encontrarMinimo(actual.derecho);
            System.out.println("Nodo con valor " + valor + " eliminado, le sigue " + sucesor);
            actual.valor = sucesor;
            actual.derecho = eliminarnodo(actual.derecho, sucesor);
        }

        return actual;
    }

    private int encontrarMinimo(Nodo_Arbol nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo.valor;
    }


    public void actualizar(int valorViejo, int valorNuevo) {
        eliminar(valorViejo);
        insertar(valorNuevo);
    }


    public void entreorden() {
        etnreorden_Recursivo(raiz);
    }

    private void etnreorden_Recursivo(Nodo_Arbol nodo) {
        if (nodo == null) return;

        etnreorden_Recursivo(nodo.izquierdo);
        System.out.print(nodo.valor + " ");
        etnreorden_Recursivo(nodo.derecho);
    }

    public void preorden() {
        preorden_Recursivo(raiz);
    }

    private void preorden_Recursivo(Nodo_Arbol nodo) {
        if (nodo == null) return;
        System.out.print(nodo.valor + " ");
        preorden_Recursivo(nodo.izquierdo);
        preorden_Recursivo(nodo.derecho);
    }

    public void postorden() {
        postorden_Recursivo(raiz);
    }

    private void postorden_Recursivo(Nodo_Arbol nodo) {
        if (nodo == null) return;
        postorden_Recursivo(nodo.izquierdo);
        postorden_Recursivo(nodo.derecho);
        System.out.print(nodo.valor + " ");
    }
    public Nodo_Arbol getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo_Arbol raiz) {
        this.raiz = raiz;
    }
}

