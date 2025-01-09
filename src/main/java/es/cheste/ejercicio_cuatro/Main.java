package es.cheste.ejercicio_cuatro;

public class Main {

    public static void main(String[] args) throws InterruptedException{


        RepartirAlitas repartirAlitas = new RepartirAlitas();

        Thread[] hilos = new Thread[30];
        for(int i = 0; i<30; i++){


            hilos[i] = new Thread(repartirAlitas,"Compañero-" + (i+1));
            hilos[i].start();

        }
        for(int i = 0; i<30; i++){

            hilos[i].join();

        }
        System.out.println("Se han consumido todas las alitas");

    }
}
