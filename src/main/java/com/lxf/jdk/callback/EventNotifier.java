package com.lxf.jdk.callback;

public class EventNotifier {
    private InterestingEvent ie;
    private boolean somethingHappened ;
    public EventNotifier() {
        somethingHappened = true ;
    }
    public void setInterestingEvent(InterestingEvent ie){
        this.ie = ie ;
    }
    public void doWork(){
        if(somethingHappened){
            ie.interestingEvent();
        }
    }
}
