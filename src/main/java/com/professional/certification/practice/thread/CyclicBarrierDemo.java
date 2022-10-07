package com.professional.certification.practice.thread;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    static class Player extends Thread {
        CyclicBarrier cb;

        public Player(CyclicBarrier cb) {
            this.cb = cb;
            this.start();
        }

        @Override
        public void run() {
            System.out.println("awaiting...");
            try {
                cb.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class Match implements Runnable {
        @Override
        public void run() {
            System.out.println("Bupp !! i got executed....");
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(2, new Match());
        Player p = new Player(cb);
        new Player(cb);
    }
}
