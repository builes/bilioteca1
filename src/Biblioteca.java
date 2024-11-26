import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

    static ArrayList<Libro> libros = new ArrayList<>();
    static Scanner keyIn = new Scanner (System.in);

    public static String[][] sciFiBooks = {
            {"Dune", "Herbert", "Frank", "Chilton Books", "1965", "412", "4.5"},
            {"1984", "Orwell", "George", "Secker & Warburg", "1949", "328", "4.2"},
            {"Stranger in a Strange Land", "Heinlein", "Robert A.", "G.P. Putnam's Sons", "1961", "408", "4.0"},
            {"The Left Hand of Darkness", "Le Guin", "Ursula K.", "Ace Books", "1969", "304", "4.1"},
            {"Neuromancer", "Gibson", "William", "Ace Books", "1984", "271", "3.9"},
            {"Ender's Game", "Card", "Orson Scott", "Tor Books", "1985", "324", "4.3"},
            {"The War of the Worlds", "Wells", "H.G.", "William Heinemann", "1898", "288", "3.8"},
            {"Brave New World", "Huxley", "Aldous", "Chatto & Windus", "1932", "311", "3.9"},
            {"The Time Machine", "Wells", "H.G.", "William Heinemann", "1895", "118", "3.8"},
            {"The Handmaid's Tale", "Atwood", "Margaret", "McClelland and Stewart", "1985", "311", "4.1"}
    };

    public static void iniciarBiblioteca() {
        Biblioteca biblioteca = new Biblioteca();
        for (String[] book : sciFiBooks) {
            String titulo = book[0];
            String autor = (book[1] + " " + book[2]);
            int numeroDePaginas = Integer.parseInt(book[5]);
            Libro libro = new Libro(titulo, autor, numeroDePaginas);
            libros.add(libro);
        }
    }


    public static void agregarLibro(Libro libro){
        for (Libro lbr: libros){
            if(lbr.equals(libro)){
                System.out.println("El libro ya se encuentra registrado");
                return;
            }
        }
        System.out.println("El libro ha sido agregado");
        libros.add(libro);
    }

    public static void agregarLibro(){
        Libro libro = new Libro();
        System.out.println ("Ingresa el título del libro -->");
        libro.setTitulo(keyIn.nextLine());
        System.out.println ("Ingresa el nombre del autor -->");
        libro.setAutor(keyIn.nextLine());
        System.out.println ("Ingresa el número de páginas -->");
        libro.setNumeroPaginas(Integer.parseInt(keyIn.nextLine()));
        libros.add(libro);
        keyIn.close();
    }

    public static void prestarLibro(Persona persona){
        System.out.println("Selecciona el numero del libro que deseas prestar");
        mostrarLibrosDisponibles();
        int index = Integer.parseInt(keyIn.next());
        if(index > 0 && index <= libros.size()){
            libros.get(index - 1).setEstaPrestado(true);
            persona.getLibrosUsuario().add(libros.get(index - 1));
            return;
        }
        System.out.println("Rango invalido");
    }

    public static void mostrarLibros(){
        int indice = 1;
        for (Libro libro: libros){
            System.out.println(indice + " " + libro);
            indice++;
        }
    }

    public static void mostrarLibrosDisponibles(){
        int indice = 1;
        for (Libro libro: libros){
            if(!libro.isEstaPrestado()){
                System.out.println(indice + " " + libro);
                indice++;
            }

        }
    }




    public static void main(String[] args) {

        iniciarBiblioteca();

        Persona persona = new Persona("Juan", "Cortez");

        //Libro libro1 = new Libro("Dune", "algo", 412);

//        agregarLibro(libro1);

        do {
            System.out.println("""
                    1) Agregar Libro
                    2) Mostrar libros
                    3) Prestar libro
                    4) Devolver libro
                    5) Salir
                    """);

            int opcion = keyIn.nextInt();
            keyIn.nextLine();

            switch (opcion){
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    mostrarLibros();
                    break;
                case 3:
                    prestarLibro(persona);
                    break;
                case 4:
                    mostrarLibros();
                    break;
                case 5:
                    return;
            }

        }while (true);

    }
}
