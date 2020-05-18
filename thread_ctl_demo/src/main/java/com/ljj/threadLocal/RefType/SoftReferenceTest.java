package com.ljj.threadLocal.RefType;

import java.io.IOException;
import java.lang.ref.SoftReference;

/**
 * 软引用：内存不够就回收，不能手动断软引用
 */
public class SoftReferenceTest {
    public static void main(String[] args) throws IOException {

        softRefMemoryEnough();
        //第一种情况演示完毕，这时候 softRefMemoryEnough()的方法栈应该已经关闭，里面所有对象的gcroot都消失了，手动清空一下，不影响下面的测试
        System.gc();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("------内存不够用的情况------");
        softRefMemoryNotEnough();
    }

    private static void softRefMemoryEnough() {
        //创建一个硬引用
        M M1 = new M(1);
        //创建一个软引用，也引用这个M对象，其中s1指向SoftReference对象是硬引用，而SoftRefWerence对象指向M1是软引用
        SoftReference<Object> s1 = new SoftReference<Object>(M1);
        System.out.println(M1);//java.lang.Object@74a14482

        System.out.println(s1.get());//java.lang.Object@74a14482
        M1 = null;
        //手动呼唤一下gc，然后给gc线程时间执行
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(M1);//null
        System.out.println(s1.get());//com.ljj.threadLocal.RefType.M@4554617c
    }

    /**
     * JVM配置`-Xms5m -Xmx5m` ，然后故意new一个一个大对象，使内存不足产生 OOM，看软引用回收情况
     */
    private static void softRefMemoryNotEnough() {
        byte[] bytes = new byte[10 * 1024 * 1024];
        SoftReference<byte[]> s1 = new SoftReference<byte[]>(bytes);
        System.out.println(bytes);
        System.out.println(s1.get());
        try {
            //再来一个硬引用大对象，由于bytes也是硬引用，一加直接OOM
            byte[] bytes2 = new byte[12 * 1024 * 1024];
        }catch (OutOfMemoryError e){
            System.out.println("内存溢出！！！！！！");
        }
        //断开bytes的硬引用
        bytes = null;
        System.out.println(bytes);
        System.out.println(s1.get());
        //然后再来一手硬引用大对象，这下不报错了，但是把s1挤掉了
        //byte[] bytes2 = new byte[12 * 1024 * 1024];
        //再试试新来个软引用，也是会把s1挤掉
        SoftReference<byte[]> s2 = new SoftReference<byte[]>(new byte[12 * 1024 * 1024]);
        System.out.println(s1.get());
        System.out.println(s2.get()[3]=12);
        System.out.println("概束");


    }



}
