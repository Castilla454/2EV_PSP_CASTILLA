package es.cheste.ejercicio_dos;

public class Contador implements Runnable {
    private String nombreHilo;
    private int inicioContador;
    private int limiteContador;


    public Contador(String nombreHilo, int inicioContador, int limiteContador) {
        this.nombreHilo = nombreHilo;
        this.inicioContador = inicioContador;
        this.limiteContador = limiteContador;
    }


    @Override
    public void run() {
        int i = 0;
        System.out.println(nombreHilo);
        for (i = inicioContador; i <= limiteContador; i++) {

            System.out.println(i);


        }


    }
}
