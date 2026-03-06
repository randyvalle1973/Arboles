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

    public boolean eliminar(Nodo_ArbolG padre, int dato) {
        if (padre == null) {
            System.out.println("El árbol está vacío");
            return false;
        }
        for (int i = 0; i < padre.hijos.size(); i++) {
            Nodo_ArbolG hijo = padre.hijos.get(i);

            if (hijo.dato == dato) {
                padre.hijos.remove(i);
                System.out.println("Dato " + dato + " removido correctamente");
                return true;
            } else {
                if (eliminar(hijo, dato)) {
                    return true;
                }

            }
        }
        return false;
    }

    public boolean actualizar(Nodo_ArbolG nodo, int datoViejo, int datoNuevo) {
        if (nodo.dato == datoViejo) {
            nodo.dato = datoNuevo;
            return true;
        }

        for (Nodo_ArbolG hijo : nodo.hijos) {
            if (actualizar(hijo, datoViejo, datoNuevo)) {
                return true;
            }
        }

        return false;
    }

    public void preorden(Nodo_ArbolG nodo) {
        if (nodo == null) return;

        System.out.print(nodo.dato + " ");

        for (Nodo_ArbolG hijo : nodo.hijos) {
            preorden(hijo);
        }
    }

    public void postorden(Nodo_ArbolG nodo) {
        if (nodo == null) return;

        for (Nodo_ArbolG hijo : nodo.hijos) {
            postorden(hijo);
        }

        System.out.print(nodo.dato + " ");
    }


    public Nodo_ArbolG getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo_ArbolG raiz) {
        this.raiz = raiz;
    }
}
