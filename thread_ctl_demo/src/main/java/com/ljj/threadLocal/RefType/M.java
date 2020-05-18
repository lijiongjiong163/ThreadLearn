package com.ljj.threadLocal.RefType;

public class M {
    int i;

    public M() {
    }

    public M(int i) {
        this.i = i;
    }

    @Override
    protected void finalize() throws Throwable {

        System.out.println("回收此对象！！M"+i);
    }
}
