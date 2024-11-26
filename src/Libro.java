import java.util.Objects;

public class Libro {
    private String titulo;
    private String autor;
    private int numeroPaginas;
    private boolean estaPrestado;

    public Libro(String titulo, String autor, int numeroPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.estaPrestado = false;
    }

    public Libro(){}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public boolean isEstaPrestado() {
        return estaPrestado;
    }

    public void setEstaPrestado(boolean estaPrestado) {
        this.estaPrestado = estaPrestado;
    }


    //public  void mostrarInformacion(){}

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", estaPrestado=" + estaPrestado +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        Libro libro = (Libro)obj;
        return this.titulo.equals(libro.getTitulo()) && numeroPaginas == libro.getNumeroPaginas();
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, numeroPaginas);
    }
}
