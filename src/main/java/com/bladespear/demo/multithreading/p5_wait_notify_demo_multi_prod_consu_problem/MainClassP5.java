package com.bladespear.demo.multithreading.p5_wait_notify_demo_multi_prod_consu_problem;

import java.util.LinkedList;
import java.util.concurrent.*;

public class MainClassP5 {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        int maxCapacity = 4;
        Producer5 producer1 = new Producer5(queue, maxCapacity);
        Producer5 producer2 = new Producer5(queue, maxCapacity);
        Producer5 producer3 = new Producer5(queue, maxCapacity);
        Producer5 producer4 = new Producer5(queue, maxCapacity);
        Producer5 producer5 = new Producer5(queue, maxCapacity);
        Consumer5 consumer1 = new Consumer5(queue);
        Consumer5 consumer2 = new Consumer5(queue);
        Consumer5 consumer3 = new Consumer5(queue);
        Consumer5 consumer4 = new Consumer5(queue);
        Consumer5 consumer5 = new Consumer5(queue);

        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);
        CustomThreadFactory customThreadFactory = new CustomThreadFactory();
        ExecutorService pool = new ThreadPoolExecutor(10, 10, 5, TimeUnit.SECONDS, workQueue, customThreadFactory);

        pool.execute(producer1);
        pool.execute(producer2);
        pool.execute(producer3);
        pool.execute(producer4);
        pool.execute(producer5);

        pool.execute(consumer1);
        pool.execute(consumer2);
        pool.execute(consumer3);
        pool.execute(consumer4);
        pool.execute(consumer5);

    }
}
