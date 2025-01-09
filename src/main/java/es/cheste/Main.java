package es.cheste;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int numhilos = 7;
        OperacionMatematicaThread op;

        for(int i =0; i<numhilos;i++){
            op= new OperacionMatematicaThread("nº " + i);
            Thread hilo = new Thread(op);


            //Asignar prioridades a los hilos
            if(i % 2 == 0){

                hilo.setPriority(Thread.MAX_PRIORITY);

            } else {

                hilo.setPriority(Thread.MIN_PRIORITY);
            }


            hilo.start();

        }


    }
}