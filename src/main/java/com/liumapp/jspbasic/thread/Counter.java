package com.liumapp.jspbasic.thread;

import static sun.jvm.hotspot.runtime.PerfMemory.start;

/**
 * Created by liumapp on 7/13/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class Counter {
    public volatile static int count = 0 ;

    public static void inc () {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main (String[] args) {
        for (int i = 0 ; i < 1000 ; i++) {
            new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        Counter.inc();
                    }
                }
            ).start();
        }
        System.out.println("1000个进程得出的计数结果： " + count);
    }
}
