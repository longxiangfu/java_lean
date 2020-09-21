package com.lxf.jdk.concurrent.completionService;

import java.util.Random;
import java.util.concurrent.*;

/**
 * CompletionService：整合了Executor和BlockingQueue
 */
public class Test {
    //Executor   BlockingQueue
    public void count1() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService1 = Executors.newWorkStealingPool();
        BlockingQueue<Future<Integer>> queue = new LinkedBlockingDeque<>();
        for (int i = 0; i < 10; i++){
            Future<Integer> future = executorService.submit(getTask());
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("aaa");
//                }
//            });
            queue.add(future);
        }
        int sum = 0;
        int queueSize = queue.size();
        for (int i = 0; i < queueSize; i++) {
            sum += queue.take().get();//Future.get();是阻塞方法
        }
        System.out.println("总数为：" + sum);
        executorService.shutdown();
    }

    //CompletionService
    public void count2() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);
        for (int i = 0; i < 10; i++) {
            completionService.submit(getTask());
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = completionService.take();
            sum += future.get();
        }
        System.out.println("总数为:" + sum);
        executorService.shutdown();
    }


    public Callable<Integer> getTask(){
        final Random random = new Random();
        Callable<Integer> task = new Callable<Integer>(){
            @Override
            public Integer call() throws Exception {
                int i = random.nextInt(10);
                int j = random.nextInt(10);
                int sum = i * j;
                Thread.sleep(5000);
                return sum;
            }
        };

        return task;
    }


    public void getTaskForRunnable() {
        new Runnable(){
            @Override
            public void run() {
                System.out.println("Runnable");
            }
        };
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Test test = new Test();
        test.count1();
//        test.count2();
    }
}
