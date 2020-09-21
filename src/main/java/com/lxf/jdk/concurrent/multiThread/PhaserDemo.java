package com.lxf.jdk.concurrent.multiThread;

import java.util.concurrent.Phaser;

/**
 * Phaser:移相器：一批又一批
 * 1、register():注册新的参与者到Phaser
 * 2、arriveAndAwaitAdvance():抵达Phaser，并且等待未抵达的线程
 * 3、一个景点一个景点的参观
 */
public class PhaserDemo {
    public static void main(String[] args) {
        Phaser phaser = new MyPhaser();
        for (int i = 0; i < 5; i++) {
            //注册新的参与者到Phaser
            phaser.register();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() ->{
                //集合完毕发车（第一阶段完成）
                phaser.arriveAndAwaitAdvance();//线程抵达Phaser，并等待其他线程
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //景点1集合完毕发车（第二阶段完成）
                phaser.arriveAndAwaitAdvance();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //景点2集合完毕发车（第三阶段完成）
                phaser.arriveAndAwaitAdvance();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


    private static class MyPhaser extends Phaser{
        /**
         * 每个阶段完成之后的事件通知
         * @param phase
         * @param registeredParties
         * @return
         */
        @Override
        protected boolean onAdvance(int phase, int registeredParties){
            boolean isTerminated = false;
            switch (phase){
                case 0 :
                    System.out.println("集合完毕发车");
                    return isTerminated;
                case 1:
                    System.out.println("景点1集合完毕发车");
                    return isTerminated;
                case 2:
                    System.out.println("景点2集合完毕发车");
                    return isTerminated;
                default:
                    return !isTerminated;
            }

        }

    }


}
