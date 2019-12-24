package com.storage;

/**
 * @author zhangyq
 * @create 2019-09-28 20:05
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread.sleep(1000);//模拟入库操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                sendMsg();
            }
        }).start();

        sendMsg();
        System.out.println("耗时："+ ( System.currentTimeMillis()-start));
    }

    public static void sendMsg(){
        try {
            Thread.sleep(1000);//模拟发信息
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
