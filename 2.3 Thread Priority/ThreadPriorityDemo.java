// Thread Priority Demo
// By Henry Smith
// Created: Mar 16 2026


class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    // A "for{" loop that loops 1000 times, with 100 milliseconds per loop
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(getName() + " is running: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }
}

public class ThreadPriorityDemo {
    public static void main(String[] args) {

        // Creates 4 threads
        MyThread t1 = new MyThread("Low Priority Thread");
        MyThread t2 = new MyThread("Medium Priority Thread");
        MyThread t3 = new MyThread("High Priority Thread");
        MyThread t4 = new MyThread("Custom Priority Thread");

        // Sets each thread's priority
        t1.setPriority(Thread.MIN_PRIORITY); // Priority 1
        t2.setPriority(Thread.NORM_PRIORITY); // Priority 5
        t3.setPriority(Thread.MAX_PRIORITY); // Priority 10
        t4.setPriority(7);

        // Starts the threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}