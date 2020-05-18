package com.ljj.threadLocal.RefType;


import java.io.IOException;

/**
 * 强引用例子，宁可OOM也不回收，断了引用才回收
 */
public class NormalReferenceTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        M m = new M(1);
        m = null;
        System.gc();//告诉jvm该回收了，但是具体回不回收，什么时候收还是看jvm心情
        System.in.read();//用于阻塞主线程的
    }
}
