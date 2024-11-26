import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;

public class Revista extends ItemBiblioteca implements Catalogable {

    private int nroEdicion;
    private int cantidadEjemplares;
    private String nombreRevista;
    private final int MULTA_POR_DIA = 1500;
    private final int DIAS_SIN_MULTA = 10;
    private LocalDate fechaPrestamo;

    public Revista(int nroEdicion, int cantidadEjemplares, String nombreRevista) {
        this.nroEdicion = nroEdicion;
        this.cantidadEjemplares = cantidadEjemplares;
        this.nombreRevista = nombreRevista;
        inicializarFechaPrestamo();
    }

    public int getNroEdicion() {
        return nroEdicion;
    }

    public void setNroEdicion(int nroEdicion) {
        this.nroEdicion = nroEdicion;
    }

    public int getCantidadEjemplares() {
        return cantidadEjemplares;
    }

    public void setCantidadEjemplares(int cantidadEjemplares) {
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    @Override
    public void prestar(){
        if(cantidadEjemplares > 0){
            cantidadEjemplares--;
            return;
        }
        System.out.println("Prestamo exitoso");
    }

    public void devolver() {
        cantidadEjemplares++;
        int diasPrestamo = calcularDiasPrestamo();

        if (diasPrestamo <= DIAS_SIN_MULTA) {
            System.out.println("Devolución exitosa");
            return;
        }

        int multa = calcularMulta(diasPrestamo);
        System.out.println("Devolución exitosa con multa de: $" + multa);
    }

    private int calcularDiasPrestamo() {
        return (int) ChronoUnit.DAYS.between(fechaPrestamo, LocalDate.now());
    }

    public int calcularMulta(int diasPrestamo) {
        int diasExcedidos = diasPrestamo - DIAS_SIN_MULTA;
        return diasExcedidos * MULTA_POR_DIA;
    }

    private void inicializarFechaPrestamo() {
        Random random = new Random();
        int diasAtras = 2 + random.nextInt(29);

        // ChronoUnit.DAYS esto asegura que estamos trabajando con dias
        this.fechaPrestamo = LocalDate.now().minus(diasAtras, ChronoUnit.DAYS); // Fecha aleatoria entre 2 y 30 días atrás
    }

    public void obtenerInformacion() {
        // Usando printf para imprimir directamente en la consola
        System.out.printf("""
            Revista: %s
            Número de Edición: %d
            Cantidad de Ejemplares: %d
            Fecha de Préstamo: %s
            """, nombreRevista, nroEdicion, cantidadEjemplares, fechaPrestamo);
    }
}
