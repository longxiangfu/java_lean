package com.lxf.jdk.callback;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventNotifier {
    private static final ExecutorService SERVICE = Executors.newWorkStealingPool();
    private InterestingEvent ie;
    private boolean somethingHappened ;

    public EventNotifier() {
        somethingHappened = true;
    }

    public void setInterestingEvent(InterestingEvent ie){
        this.ie = ie ;
    }

    public void doWork(){
        if(somethingHappened){
            SERVICE.submit(() -> ie.interestingEvent());
        }
    }
}
