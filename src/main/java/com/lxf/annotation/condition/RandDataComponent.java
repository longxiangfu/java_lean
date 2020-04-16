package com.lxf.annotation.condition;

import org.springframework.stereotype.Component;

/**
 * 作用：产生一个数
 * @param <T>
 */
@Component
public class RandDataComponent<T> {
    private T rand;


    public T getRand(){
        return rand;
    }

    public void setRand(T rand){
        this.rand = rand;
    }

}
