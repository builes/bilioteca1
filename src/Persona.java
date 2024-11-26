import java.util.ArrayList;

public class Persona {
    private String nombre;
    private String apellido;
    private ArrayList<Libro> librosUsuario = new ArrayList<>();

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public ArrayList<Libro> getLibrosUsuario() {
        return librosUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setLibrosUsuario(ArrayList<Libro> librosUsuario) {
        this.librosUsuario = librosUsuario;
    }
}
