package Arbol_General;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Arbol_Genealogico {
    Nodo_ArbolG raiz;

    public Arbol_Genealogico(persona datoRaiz) {
        raiz = new Nodo_ArbolG(datoRaiz);
    }

    public void insertarHijo(Nodo_ArbolG padre, persona datoHijo) {

        Nodo_ArbolG nuevo = new Nodo_ArbolG(datoHijo);
        padre.hijos.add(nuevo);
    }

    public boolean eliminar(Nodo_ArbolG padre, String dato) {
        if (padre == null) {
            System.out.println("El árbol está vacío");
            return false;
        }
        if (raiz.dato.nombre_Pero.equalsIgnoreCase(dato)) {
            raiz = null;
            System.out.println("Dato " + dato + " removido correctamente");
            return true;
        }
        for (int i = 0; i < padre.hijos.size(); i++) {
            Nodo_ArbolG hijo = padre.hijos.get(i);

            if (hijo.dato.nombre_Pero.equalsIgnoreCase(dato)) {
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

    public boolean actualizar(Nodo_ArbolG nodo, String datoViejo, String datoNuevo) {
        if (nodo.dato.nombre_Pero.equalsIgnoreCase(datoViejo)) {
            nodo.dato.nombre_Pero = datoNuevo;
            return true;
        }

        for (Nodo_ArbolG hijo : nodo.hijos) {
            if (actualizar(hijo, datoViejo, datoNuevo)) {
                return true;
            }
        }

        return false;
    }
    public boolean agregarRelacion(Nodo_ArbolG nodo, persona referencia, persona nuevaPersona, String relacion) {

        if (nodo == null) return false;

        if (nodo.dato.nombre_Pero.equalsIgnoreCase(referencia.getNombre_Pero())) {

            if (relacion.equalsIgnoreCase("hijo")) {

                Nodo_ArbolG nuevo = new Nodo_ArbolG(nuevaPersona);
                nodo.hijos.add(nuevo);

            } else if (relacion.equalsIgnoreCase("padre") || relacion.equalsIgnoreCase("madre")) {

                Nodo_ArbolG nuevoPadre = new Nodo_ArbolG(nuevaPersona);
                nuevoPadre.hijos.add(nodo);

                if (nodo == raiz) {
                    raiz = nuevoPadre;
                }
            }

            return true;
        }

        for (Nodo_ArbolG hijo : nodo.hijos) {

            if (agregarRelacion(hijo, referencia, nuevaPersona, relacion)) {
                return true;
            }

        }

        return false;
    }

    public void mostrarAntepasados(String nombre) {

        List<Nodo_ArbolG> camino = new ArrayList<>();

        if (buscarCamino(raiz, nombre, camino)) {

            System.out.println("Línea de antepasados de " + nombre + ":");

            for (Nodo_ArbolG nodo : camino) {
                System.out.println(nodo.dato);
            }

        } else {
            System.out.println("Persona no encontrada");
        }
    }

    private boolean buscarCamino(Nodo_ArbolG nodo, String nombre, List<Nodo_ArbolG> camino) {
        if (nodo == null) return false;
        camino.add(nodo);
        if (nodo.dato.nombre_Pero.equalsIgnoreCase(nombre)) {
            return true;
        }
        for (Nodo_ArbolG hijo : nodo.hijos) {
            if (buscarCamino(hijo, nombre, camino)) {
                return true;
            }
        }

        camino.remove(camino.size() - 1);

        return false;
    }
    public void mostrarDescendientes(Nodo_ArbolG nodo, String nombre) {

        if (nodo == null) return;

        if (nodo.dato.getNombre_Pero().equalsIgnoreCase(nombre)) {

            for (Nodo_ArbolG hijo : nodo.hijos) {
                preorden(hijo);
            }

            return;
        }

        for (Nodo_ArbolG hijo : nodo.hijos) {
            mostrarDescendientes(hijo, nombre);
        }
    }

    public int profundidadArbol(Nodo_ArbolG nodo) {

        if (nodo == null) {
            return -1;
        }

        int maxProfundidad = -1;

        for (Nodo_ArbolG hijo : nodo.hijos) {

            int profundidadHijo = profundidadArbol(hijo);

            if (profundidadHijo > maxProfundidad) {
                maxProfundidad = profundidadHijo;
            }
        }

        return maxProfundidad + 1;
    }

    public void BFS() {

        if (raiz == null) {
            System.out.println("El árbol está vacío");
            return;
        }

        Queue<Nodo_ArbolG> cola = new LinkedList<>();
        cola.add(raiz);

        int nivel = 0;

        while (!cola.isEmpty()) {

            int cantidadNodos = cola.size();

            System.out.print("Generacion " + nivel + ": ");

            for (int i = 0; i < cantidadNodos; i++) {

                Nodo_ArbolG actual = cola.poll();

                System.out.print(actual.dato + " ");

                for (Nodo_ArbolG hijo : actual.hijos) {
                    cola.add(hijo);
                }
            }

            System.out.println();
            nivel++;
        }
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
