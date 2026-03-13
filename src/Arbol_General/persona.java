package Arbol_General;

public class persona {
    String nombre_Pero;
    String fecha;
    char genero;

    public persona(String nombre_Pero, String fecha, char genero) {
        this.nombre_Pero = nombre_Pero;
        this.fecha = fecha;
        this.genero = genero;
    }

    public String getNombre_Pero() {
        return nombre_Pero;
    }

    public void setNombre_Pero(String nombre_Pero) {
        this.nombre_Pero = nombre_Pero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "persona{" +
                "nombre_Pero='" + nombre_Pero + '\'' +
                ", fecha='" + fecha + '\'' +
                ", genero=" + genero +
                '}';
    }
}
