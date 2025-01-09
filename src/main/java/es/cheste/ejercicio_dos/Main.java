package es.cheste.ejercicio_dos;


import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Contador> contadores = new ArrayList<Contador>();

        Contador contador1 = new Contador("Contador de 23 a 55", 23, 55);
        Contador contador2 = new Contador("Contador de 10 a 15", 10, 15);
        Contador contador3 = new Contador("Contador de 110 a 135", 110, 135);
        Contador contador4 = new Contador("Contador de 0 a 43", 0, 43);
        Contador contador5 = new Contador("Contador de 69 a 77", 69, 77);

        contadores.add(contador1);
        contadores.add(contador2);
        contadores.add(contador3);
        contadores.add(contador4);
        contadores.add(contador5);

        List<Thread> hilosContadores = new ArrayList<Thread>();

        for(Contador hilos : contadores){

            Thread hilo = new Thread(hilos);
            hilosContadores.add(hilo);


        }



        for(int i = 0 ; i<hilosContadores.size();i++){

            hilosContadores.get(i).start();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


        try{
            for(int i = 0 ; i<hilosContadores.size();i++) {
                hilosContadores.get(i).join();
            }

        } catch(InterruptedException e){

            e.printStackTrace();
        }
        System.out.println("Todos los hilos han terminado");

    }
}
