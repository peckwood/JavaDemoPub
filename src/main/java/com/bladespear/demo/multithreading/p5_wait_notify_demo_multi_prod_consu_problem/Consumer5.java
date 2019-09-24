package com.bladespear.demo.multithreading.p5_wait_notify_demo_multi_prod_consu_problem;

import java.util.LinkedList;
import java.util.Random;

public class Consumer5 implements Runnable {
    private final LinkedList<Integer> integerQueue;
    private Random random = new Random();
    private String threadName;

    @Override
    public void run() {
        threadName = Thread.currentThread().getName();
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {

        synchronized (integerQueue) {
            System.out.println(String.format("Consumer %s has lock", threadName));
            if (integerQueue.isEmpty()) {
                System.out.println(String.format("Queue empty, %s waits.", threadName));
                integerQueue.wait();
            }
            Integer number = integerQueue.pop();
            System.out.println(String.format("%s consumed %d, integerQueue: %s", threadName, number, integerQueue));
            integerQueue.notifyAll();
            System.out.println(String.format("Consumer %s notified All", threadName));
        }
        Thread.sleep(random.nextInt(1000));
    }

    public Consumer5(LinkedList<Integer> integerQueue) {
        this.integerQueue = integerQueue;
    }
}