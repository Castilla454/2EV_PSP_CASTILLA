package es.cheste.ejercicio_uno;

public class MostrarASCII implements Runnable {

    private int tipo;

    public MostrarASCII(int tipo) {
        this.tipo = tipo;
    }


    @Override
    public void run() {
        for (int i = 32; i <= 126; i++) {

            if ((tipo == 1) && (i % 2 != 0)) {
                System.out.println("ASCII de " + i + ": " + (char) i);

            }


        }
        for(int i = 32;i <= 126;i++){

            if ((tipo == 2) && (i % 2 == 0)) {

                System.out.println("ASCII de " + i + ": " + (char) i);

            }

        }


    }

}

