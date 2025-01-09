package es.cheste.ejercicio_tres;

import es.cheste.ejercicio_dos.Contador;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Caracol[] caracoles = new Caracol[5];

        Caracol caracol1 = new Caracol(10, "Juan");
        caracoles[0] = caracol1;
        Caracol caracol2 = new Caracol(10, "Pepito");
        caracoles[1] = caracol2;
        Caracol caracol3 = new Caracol(10, "Noche");
        caracoles[2] = caracol3;
        Caracol caracol4 = new Caracol(10, "Jayce");
        caracoles[3] = caracol4;
        Caracol caracol5 = new Caracol(10, "Heimer");
        caracoles[4] = caracol5;

        Thread hilo1 = new Thread(caracol1);
        Thread hilo2 = new Thread(caracol2);
        Thread hilo3 = new Thread(caracol3);
        Thread hilo4 = new Thread(caracol4);
        Thread hilo5 = new Thread(caracol5);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();


        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
            hilo5.join();


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
