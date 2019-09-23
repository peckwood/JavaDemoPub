package com.bladespear.demo.multithreading.p4_wait_notify_demo_producer_consumer1_improved.p3_wait_notify_demo_producer_consumer;

import java.util.LinkedList;
import java.util.Random;

public class Producer implements Runnable {

    private final LinkedList<Integer> integerQueue;
    private final int MAX_CAPACITY;
    private int number = 1;
    private Random random = new Random();

    @Override
    public void run() {
        int i = 1;
        while (true) {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            if (integerQueue.size() < MAX_CAPACITY) {
//                int number = i++;
//                synchronized (integerQueue){
//                    integerQueue.add(number);
//                    System.out.println(String.format("Produced %d, integerQueue: %s", number, integerQueue));
//                }
//            }
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }
    }

    public Producer(LinkedList<Integer> integerQueue, int MAX_CAPACITY) {
        this.integerQueue = integerQueue;
        this.MAX_CAPACITY = MAX_CAPACITY;
    }

    private void produce() throws InterruptedException {
        synchronized (integerQueue){
            if(integerQueue.size() == MAX_CAPACITY){
                integerQueue.notifyAll();
                integerQueue.wait();
            }else{
                integerQueue.add(number);
                System.out.println(String.format("Produced %d, integerQueue: %s", number, integerQueue));
                number++;
                integerQueue.notifyAll();
            }
        }
        Thread.sleep(random.nextInt(1000));


//        if (integerQueue.size() < MAX_CAPACITY) {
//            int number = i++;
//            synchronized (integerQueue){
//                integerQueue.add(number);
//                System.out.println(String.format("Produced %d, integerQueue: %s", number, integerQueue));
//            }
//        }else{
//
//        }
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
