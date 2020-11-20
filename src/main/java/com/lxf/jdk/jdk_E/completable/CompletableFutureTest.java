package com.lxf.jdk.jdk_E.completable;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 演示jdk8中并发包下的CompletableFuture
 * 说明：之前异步Future只能阻塞等待结果；而现在CompletableFuture异步执行之后，通知或回调另外的任务，非常棒
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        start();
        next();
    }


    /**
     * 提交任务执行
     */
    public static void start(){
        //runAsync(Runnable): 提交执行无返回值的任务，默认执行线程是ForkJoinPool#commonPool()
        // runAsync(Runnable, Executor):提交执行无返回值的任务，指定Executor执行
//        CompletableFuture.runAsync(() ->{
//            System.out.println(Thread.currentThread().getName());
//            System.out.println("runAsync");
//        });
//        System.out.println(Thread.currentThread().getName());
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        CompletableFuture.runAsync(() ->{
//            System.out.println(Thread.currentThread().getName());
//            System.out.println("runAsync");
//        }, executorService);


        //supplyAsync(Runnable):提交有返回值的任务，默认的线程是ForkJoinPool#commonPool()
        //supplyAsync(Runnable, Executor)：提交有返回值的任务，指定Executor执行
//        CompletableFuture.supplyAsync(() ->{
//            System.out.println("supplyAsync");
//            return 1;
//        });


        //allOf：给定的所有的CompletableFuture都完成后，才完成。主线程被阻塞
        //anyOf:给定的任何一个CompletableFuture完成，就完成。主线程被阻塞
//        CompletableFuture.allOf(
//                CompletableFuture.runAsync(() -> System.out.println("allOf1")),
//                CompletableFuture.runAsync(() -> System.out.println("allOf2"))
//                );
//        CompletableFuture.anyOf(
//                CompletableFuture.runAsync(() -> {
//                    try {
//                        Thread.sleep(5000);
//                        System.out.println("anyOf1");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }),
//                CompletableFuture.runAsync(() -> {
//                    System.out.println("anyOf2");
//                })
//        );


//        CompletableFuture<Integer> completedFuture = CompletableFuture.completedFuture(1000);
//        CompletableFuture<Integer> completedFuture1 = CompletableFuture.completedFuture(null);
//        System.out.println(completedFuture.get());
//        System.out.println(completedFuture1.get());

        System.out.println(Thread.currentThread().getName());
    }


    /**
     * 执行下一阶段
     */
    public static void next() throws ExecutionException, InterruptedException {
        //thenRunAsync：不处理上阶段返回值，该阶段无返回值。因为是串行执行的，所以执行的线程可能是同一个
//        CompletableFuture.runAsync(() ->{
//            System.out.println("步骤1。线程：" + Thread.currentThread().getName());
//        }).thenRunAsync(() ->{
//            System.out.println("步骤2。线程：" + Thread.currentThread().getName());
//        });

        //thenAccept:处理上阶段返回值，该阶段无返回值。因为是串行执行的，所以执行的线程可能是同一个
//        CompletableFuture.supplyAsync(() ->{
//            System.out.println("步骤1。线程：" + Thread.currentThread().getName());
//            return 1;
//        }).thenAcceptAsync(beforeResult ->{
//            System.out.println("步骤2。上阶段结果为：" + beforeResult);
//            System.out.println("线程："  + Thread.currentThread().getName());
//        });

        //thenApplyAsync：处理上阶段返回值，该阶段有返回值。因为是串行执行的，所以执行的线程可能是同一个
//        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
//            System.out.println("步骤1。线程：" + Thread.currentThread().getName());
//            return 1;
//        }).thenApplyAsync(beforeResult -> {
//            System.out.println("步骤2。上阶段结果为：" + beforeResult);
//            System.out.println("线程：" + Thread.currentThread().getName());
//            return 2;
//        });
//        System.out.println(completableFuture.get());


        //thenCombine:合并两个任务的结果，有返回值。因为是串行执行的，所以执行的线程可能是同一个
//        CompletableFuture<Integer> completableFuture =
//                CompletableFuture.supplyAsync(() -> {
//                    System.out.println("线程：" + Thread.currentThread().getName());
//                    return 6;
//                }).thenCombineAsync(
//                        CompletableFuture.supplyAsync(() -> {
//                            System.out.println("线程：" + Thread.currentThread().getName());
//                            return 10;
//                        }),
//                        (one, two) -> {
//                            System.out.println("线程：" + Thread.currentThread().getName());
//                            return one + two;
//                });
//        System.out.println(completableFuture.get());
//        System.out.println(completableFuture.join());

        //thenAcceptBothAsync:合并两个任务的结果，无返回值。因为是串行执行的，所以执行的线程可能是同一个
//        CompletableFuture.supplyAsync(() -> {
//            System.out.println("线程：" + Thread.currentThread().getName());
//            return 1;
//        }).thenAcceptBothAsync(
//                CompletableFuture.supplyAsync(() -> {
//                    System.out.println("线程：" + Thread.currentThread().getName());
//                    return 2;
//                }),
//                (one, two) -> {
//                    System.out.println("线程：" + Thread.currentThread().getName());
//                    System.out.println(one + two);
//                }
//        );

        //runAfterBoth: 两个任务执行完后，调用指定的操作
//        CompletableFuture.supplyAsync(() -> {
//            System.out.println("第一阶段。线程：" + Thread.currentThread().getName());
//            return 6;
//        }).runAfterBothAsync(CompletableFuture.runAsync(() -> System.out.println("第二阶段：线程：" + Thread.currentThread().getName())),
//                () -> System.out.println("前面两个阶段都执行完成后执行该任务。线程：" + Thread.currentThread().getName()));

        //runAfterEither:两个任务任何一个正常完成后，调用指定的操作
//        CompletableFuture.supplyAsync(() ->{
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("第一阶段。线程：" + Thread.currentThread().getName());
//            return 1;
//        }).runAfterEitherAsync(
//                CompletableFuture.runAsync(() ->{
//                    System.out.println("第二阶段。线程：" + Thread.currentThread().getName());
//                }),
//                () -> {
//                    System.out.println("两个阶段任何一个正常完成后，调用该操作。线程：" + Thread.currentThread().getName());
//                }
//        );


        //whenComplete:当阶段完成后，将阶段的结果以及阶段的异常作为参数执行后续的操作
        CompletableFuture.supplyAsync(() ->{
            System.out.println("线程：" + Thread.currentThread().getName());
            throw new RuntimeException();
//            return 1;
        }).whenCompleteAsync((beforeResult, throwable) -> {
            System.out.println("线程：" + Thread.currentThread().getName());
            System.out.println("上阶段结果：" + beforeResult);
            System.out.println("上阶段异常：" + throwable);
        });

        //whenCompose:当阶段正常完成后，该阶段的结果作为提供函数的参数执行函数
//        CompletableFuture.supplyAsync(() ->{
//            System.out.println("线程：" + Thread.currentThread().getName());
//            return 1;
//        }).thenComposeAsync((beforeResult) ->{
//            System.out.println("线程：" + Thread.currentThread().getName());
//            return CompletableFuture.completedFuture(beforeResult);
//        });

        //handle:当阶段完成后，将阶段的结果以及阶段的异常作为参数执行后续的操作
//        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> 1).handleAsync((r, throwable) -> r + 3);
//        System.out.println(completableFuture.join());

        //join和get
//        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> 1).handleAsync((r, throwable) -> {
////            return r + 10;
//            throw new RuntimeException();
//        });
//        System.out.println(completableFuture.join());
////        System.out.println(completableFuture.get());

        //complete:如何结果还没准备好，直接调用get
        CompletableFuture.supplyAsync(() -> 1).complete(10);

        //completedFuture:返回包含指定值的CompletableFuture
        CompletableFuture.completedFuture(10);



    }
}
