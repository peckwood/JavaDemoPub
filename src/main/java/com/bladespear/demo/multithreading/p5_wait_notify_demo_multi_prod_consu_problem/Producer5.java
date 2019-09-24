package com.bladespear.demo.multithreading.p5_wait_notify_demo_multi_prod_consu_problem;

import java.util.LinkedList;
import java.util.Random;

public class Producer5 implements Runnable {

    private String threadName;
    private final LinkedList<Integer> integerQueue;
    private final int MAX_CAPACITY;
    private int number = 1;
    private Random random = new Random();

    @Override
    public void run() {
        threadName = Thread.currentThread().getName();
        while (true) {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Producer5(LinkedList<Integer> integerQueue, int MAX_CAPACITY) {
        this.integerQueue = integerQueue;
        this.MAX_CAPACITY = MAX_CAPACITY;
    }

    private void produce() throws InterruptedException {

        System.out.println(String.format("Producer %s has lock", threadName));
        synchronized (integerQueue) {
            while (integerQueue.size() == MAX_CAPACITY) {
                System.out.println(String.format("Queue full, %s waits.", threadName));
                integerQueue.wait();
            }
            integerQueue.add(number);
            System.out.println(String.format("%s produced %d, integerQueue: %s", threadName, number, integerQueue));
            number++;
            integerQueue.notifyAll();
            System.out.println(String.format("Producer %s notifiedAll", threadName));
        }
        Thread.sleep(random.nextInt(1000));
    }
}
