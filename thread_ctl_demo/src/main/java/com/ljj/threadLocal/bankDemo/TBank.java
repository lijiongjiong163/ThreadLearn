package com.ljj.threadLocal.bankDemo;

public class TBank {
    ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };


    public void setMoney(int money) {
        threadLocal.set(threadLocal.get()+money);
    }

    public Integer getMoney() {
        return threadLocal.get();
    }
}
