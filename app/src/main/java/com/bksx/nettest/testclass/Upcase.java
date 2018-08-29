package com.bksx.nettest.testclass;

public class Upcase extends Processor {
    String process(Object input){
        return ((String)input).toUpperCase();
    }


}
