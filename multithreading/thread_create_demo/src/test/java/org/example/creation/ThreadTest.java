package org.example.creation;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.*;

public class ThreadTest {
    /**
     * 使用继承thread类来创建线程
     */
    @Test
    public void myThreadTest(){
        MyThread thread = new MyThread();
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread()+",时间："+new Date().getTime());
        }
    }

    /**
     *    使用实现runnable接口来创建线程
     */
    @Test
    public void myRunnableTest(){
        //还是用thread类来创建，但是把runnable对象传进thread类的构造方法中
        Thread thread = new Thread(new myRunnable(),"runnable创建的线程");
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread()+",时间："+new Date().getTime());
        }
    }

    /**
     * 使用实现callable接口来创建线程
     */
    @Test
    public void myCallableTest() throws ExecutionException, InterruptedException {

        //1.创建futureTask对象，传进callable实现类（一层套娃）
        FutureTask<String> task = new FutureTask<>(new myCallable());
        //创建thread对象，传入futureTask对象（二层套娃）
        Thread thread = new Thread(task, "callable创建的线程");
        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread()+",时间："+new Date().getTime());
        }
        System.out.println( task.get());

    }
    /**
     * 使用线程池创建线程
     */
    @Test
    public void executorTest(){
        //1.使用线程池工具类（Executors）获取线程池对象
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //2.将runnable实现类传入线程池的execute方法,就会自动start线程并执行其run方法
        executorService.execute(new myRunnable());
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread()+",时间："+new Date().getTime());
        }
        System.out.println("测试git");
        System.out.println("第二次测试git");
    }
}
