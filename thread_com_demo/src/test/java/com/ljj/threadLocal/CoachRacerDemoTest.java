package com.ljj.threadLocal;



class CoachRacerDemoTest {

    public static void main(String[] args) {
        final CoachRacerDemo coachRacerDemo = new CoachRacerDemo();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                coachRacerDemo.recer();
            }
        }, "运动员1");
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
coachRacerDemo.recer();
            }
        }, "运动员2");
        Thread thread3 = new Thread(new Runnable() {
            public void run() {
coachRacerDemo.recer();
            }
        }, "运动员3");
        Thread thread4 = new Thread(new Runnable() {
            public void run() {
coachRacerDemo.coach();
            }
        }, "教练1");
      thread4.start();
      thread2.start();
      thread3.start();
      thread1.start();

    }

}