package es.cheste.ejercicio_tres;

import java.util.Random;

public class Caracol implements Runnable{
    private double velocidad;
    private String nombre;
    private final double DISTANCIA_CARRERA = 100;

    private boolean raceIsOver = false;

    public Caracol(double velocidad, String nombre) {
        this.velocidad = velocidad;
        this.nombre = nombre;
    }


    @Override
    public void run() {
        double distanciaRecorrida =0;
        Random random = new Random();


        while(distanciaRecorrida<DISTANCIA_CARRERA && !raceIsOver){

            double avance = random.nextDouble() * velocidad;
            distanciaRecorrida += avance;


            if(distanciaRecorrida>DISTANCIA_CARRERA || distanciaRecorrida==DISTANCIA_CARRERA){

                distanciaRecorrida = DISTANCIA_CARRERA;
                System.out.println("El caracol " + nombre + " ha llegado a la meta!!");
                raceIsOver = true;
                break;
            }

            double progreso = (distanciaRecorrida/DISTANCIA_CARRERA) *100;
            System.out.println("El caracol " +nombre + " lleva el " + progreso + "% de la carrera recorrida");

            try{Thread.sleep(100);

            } catch (InterruptedException e){

                e.printStackTrace();
            }

        }



    }
}
