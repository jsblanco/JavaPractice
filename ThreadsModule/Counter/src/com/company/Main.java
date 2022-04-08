package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Countdown countdown = new Countdown();

        CountdownThread thread1 = new CountdownThread(countdown);
        thread1.setName("Thread 1");

        CountdownThread thread2 = new CountdownThread(countdown);
        thread2.setName("Thread 2");

        List.of(thread1, thread2).forEach(Thread::start);
    }

}

class Countdown {

    private int i;

    public synchronized void doSynchronizedCountdown() {
        doCountdown();
    }

    public void doCountdown() {
        String color = switch (Thread.currentThread().getName()) {
            case "Thread 1" -> ThreadColor.ANSI_CYAN;
            case "Thread 2" -> ThreadColor.ANSI_RED;
            default -> ThreadColor.ANSI_GREEN;
        };
//        synchronized (this) {
        for (i = 10; i > 0; i--)
            System.out.println(color + Thread.currentThread().getName() + ": i=" + i);
//        }
    }
}

class CountdownThread extends Thread {
    private final Countdown threadCountdown;

    public CountdownThread(Countdown countdown) {
        threadCountdown = countdown;
    }

    public void run() {
        threadCountdown.doSynchronizedCountdown();
//            threadCountdown.doCountdown();
    }
}
