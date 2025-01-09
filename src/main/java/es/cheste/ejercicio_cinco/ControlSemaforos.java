package es.cheste.ejercicio_cinco;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ControlSemaforos {

    private int semaforoVerde = 1; // 1 para semáforo 1, 2 para semáforo 2
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void encenderSemaforo1() {
        while (true) {
            lock.lock();
            try {
                while (semaforoVerde != 1) {
                    condition.await();
                }
                System.out.println("Semáforo 1: Verde");
                Thread.sleep(5000);
                semaforoVerde = 2;
                System.out.println("Semáforo 1: Rojo");
                condition.signalAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } finally {
                lock.unlock();
            }
        }
    }

    public void encenderSemaforo2() {
        while (true) {
            lock.lock();
            try {
                while (semaforoVerde != 2) {
                    condition.await();
                }
                System.out.println("Semáforo 2: Verde");
                Thread.sleep(5000);
                semaforoVerde = 1;
                System.out.println("Semáforo 2: Rojo");
                condition.signalAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ControlSemaforos control = new ControlSemaforos();

        Thread semaforo1 = new Thread(control::encenderSemaforo1);
        Thread semaforo2 = new Thread(control::encenderSemaforo2);

        semaforo1.start();
        semaforo2.start();
    }
}