package com.ljj.threadLocal.ThreadLocal;

/**
 * 测试，同一个threadLocal对象，不同person对象，就不影响，因为虽然key一样，但是两个线程各是各的map，value不一样，不会影响
 * 同一个threadLocal对象，同一个Person对象，不同线程，还是会互相影响，是因为虽然不同的线程是不同的map，但是存的键值对一摸一样，key一样无所谓，但value都指向同一个person对象，这样还是会互相影响
 */

public class ThreadLocalTest {
    static ThreadLocal<Person> tl = new ThreadLocal<Person>();


    public static void main(String[] args) {
        final Person pr =new Person();
        System.out.println("什么鬼");
        new Thread(new Runnable() {
            @Override
            public void run() {
                pr.setName("li");
                tl.set(pr);

                System.out.println("拿出线程1"+tl.get());
                try {
                    Thread.sleep(900);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("拿出线程1第二次"+tl.get());
            }
        }

        ).start();
        new Thread(()->{
            pr.setName("张");
            tl.set(pr);
            System.out.println("拿出线程2"+tl.get());
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("什么鬼");

    }
}
