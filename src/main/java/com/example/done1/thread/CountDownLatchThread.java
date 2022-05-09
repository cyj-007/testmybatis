package com.example.done1.thread;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.RandomUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Admin
 */
public class CountDownLatchThread {
    public static void main(String[] args) {
        execute();
    }

    /**
     * 异步执行线程
     * */
    public static void execAsync(){
        try {
            for(int i=0;i<5;i++){
                ThreadUtil.execAsync(() -> {
                    int num = RandomUtil.randomInt(1000, 4000);
                    System.out.println(num);
                });
                System.out.println("第个线程:" + i);
            }

            System.out.println("完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 线程池 线程完成时 执行主线程
     * */
    public static void execute() {
        try {
            //初始化线程数量
            //新建一个CountDownLatch，一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
            CountDownLatch countDownLatch=ThreadUtil.newCountDownLatch(5);
            AtomicInteger a = new AtomicInteger();
            AtomicInteger b = new AtomicInteger();
            AtomicInteger c = new AtomicInteger();
            AtomicInteger d = new AtomicInteger();
            AtomicInteger e = new AtomicInteger();
            System.out.println("1");
            ThreadUtil.execute(() -> {
                ThreadUtil.sleep(3000);
                a.set(1);
                System.out.println(a.get()+"a");
                //调用线程计数器-1
                countDownLatch.countDown();
            });
            System.out.println("2");
            ThreadUtil.execute(() -> {
                ThreadUtil.sleep(3000);
                b.set(0);
                System.out.println(b.get()+"b");
                //调用线程计数器-1
                countDownLatch.countDown();
            });
            System.out.println("3");
            ThreadUtil.execute(() -> {
                ThreadUtil.sleep(3000);
                c.set(1);
                System.out.println(c.get()+"c");
                //调用线程计数器-1
                countDownLatch.countDown();
            });
            System.out.println("4");
            ThreadUtil.execute(() -> {
                ThreadUtil.sleep(3000);
                d.set(1);
                System.out.println(d.get()+"d");
                //调用线程计数器-1
                countDownLatch.countDown();
            });
            System.out.println("5");
            ThreadUtil.execute(() -> {
                ThreadUtil.sleep(3000);
                e.set(1);
                System.out.println(e.get()+"e");
                //调用线程计数器-1
                countDownLatch.countDown();
            });
            System.out.println("6");
            //唤醒主线程
            countDownLatch.await();
//            ThreadUtil.sleep(3000);
            System.out.println("完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
