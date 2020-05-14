package org.example.creation;

import java.util.Date;
import java.util.concurrent.Callable;

public class myCallable implements Callable<String> {

    @Override
    public String call() throws Exception{
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread()+",时间："+ new Date().getTime());
        }
        return "myCallable执行完毕！！";
    }
}
