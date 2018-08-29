package com.bksx.nettest.testclass;

public class Processor {
    public String name(){
        return getClass().getSimpleName();
    }
    //子类中重写次此方法时用其他类型如string  int 等
    Object process(Object input){
        return input;
    }
}
