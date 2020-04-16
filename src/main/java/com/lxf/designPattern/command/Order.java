package com.lxf.designPattern.command;

/**
 * 命令接口
 */
public interface Order {
    /**
     *是否支持处理
     */
    Boolean support(Stock stock);
    /**
     *执行
     */
    void execute();
}
