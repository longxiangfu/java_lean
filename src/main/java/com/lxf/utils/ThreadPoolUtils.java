package com.lxf.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtils {
  static ExecutorService cachedThreadPool;
  static ExecutorService fixedThreadPool;
  static ScheduledExecutorService scheduledThreadPool;
  static ExecutorService singleThreadPool;

  static ExecutorService cachedThreadPoolRun(Runnable runnable) {
    if (cachedThreadPool == null)
      cachedThreadPool = Executors.newCachedThreadPool();
    cachedThreadPool.submit(runnable);
    return cachedThreadPool;
  }

  public static ExecutorService fixedThreadPoolRun(Runnable runnable) {
    if (fixedThreadPool == null)
      fixedThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime()
          .availableProcessors());
    fixedThreadPool.submit(runnable);
    return fixedThreadPool;
  }

  public static ExecutorService scheduledThreadPoolRun(Runnable runnable, long delay, TimeUnit unit) {
    if (scheduledThreadPool == null)
      scheduledThreadPool = Executors.newScheduledThreadPool(Runtime.getRuntime()
          .availableProcessors());
    scheduledThreadPool.schedule(runnable, delay, unit);
    return scheduledThreadPool;
  }

  public static ExecutorService singleThreadPoolRun(Runnable runnable) {
    if (singleThreadPool == null)
      singleThreadPool = Executors.newSingleThreadExecutor();
    singleThreadPool.submit(runnable);
    return singleThreadPool;
  }
}