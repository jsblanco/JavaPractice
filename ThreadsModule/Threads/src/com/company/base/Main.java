package com.company.base;

import static com.company.base.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread!");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("////// Another thread //////");
        // Si lanzamos run en vez de start, seguiremos en el hilo original, y no en el nuevo que pretendemos crear.
        // anotherThread.run();
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the anonymous class Thread!");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable()) {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous implementation of run()");
                try {
                    anotherThread.join(2000);
                    System.out.println(ANSI_RED + "AnotherThread terminated or timed out, so I'm running again");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "I couldn't wait after all; I was interrupted!");
                }
            }
        };
        myRunnableThread.start();
        //anotherThread.interrupt();

        System.out.println(ANSI_PURPLE + "Hello from the main thread again!");

    }
}
