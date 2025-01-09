package es.cheste.ejercicio_uno;

import es.cheste.OperacionMatematicaThread;

public class Main {
    public static void main(String[] args) {
        MostrarASCII mostrarASCII = new MostrarASCII(1);
        MostrarASCII mostrarASCII1 = new MostrarASCII(2);

        Thread mostrarImpares = new Thread(mostrarASCII);
        Thread mostrarPares = new Thread(mostrarASCII1);


        mostrarImpares.start();
        mostrarPares.start();

    }


}

