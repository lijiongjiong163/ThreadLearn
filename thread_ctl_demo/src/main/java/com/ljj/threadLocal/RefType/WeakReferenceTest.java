package com.ljj.threadLocal.RefType;

import java.lang.ref.WeakReference;

/**
 * 弱引用：只要碰到GC就回收
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
        WeakReference<M> wr = new WeakReference<M>(new M(1));
        System.out.println(wr.get());
        System.gc();
        System.out.println(wr.get());


    }
}
