package es.cheste.ejercicio_cuatro;

import java.util.Random;

public class RepartirAlitas implements Runnable {

    private int totalAlitas = 100;
    private static final Object lock = new Object();
    private boolean quedanAlitas = true;


    public void consumirAlita() {

        Random random = new Random();
        int alitasPorConsumir = random.nextInt(10) + 1;

        synchronized (lock) {

            if (totalAlitas >= alitasPorConsumir) {

                totalAlitas -= alitasPorConsumir;
                System.out.println(Thread.currentThread().getName() + " ha consumido " + alitasPorConsumir + " alitas. Quedan " + totalAlitas);

            } else if (totalAlitas> 0) {

                System.out.println(Thread.currentThread().getName() + " ha consumido las alitas restantes");
                totalAlitas = 0;


            }

            if(totalAlitas == 0){

                quedanAlitas = false;
            }


        }


    }


    @Override
    public void run() {
        while (totalAlitas > 0 && quedanAlitas) {
            consumirAlita();

        }
    }
}
