package com.bksx.nettest.testpackage;

import com.bksx.nettest.testclass.Hero;

public class InterfaceTest extends Hero implements  All {

    public void doF(First f){
        System.out.println("doFirst");
    }
    public void doS(Second s){
        System.out.println("doSecond");
    }
    public void doT(Third t){
        System.out.println("doThird");
    }
    public void doA(All a){
        System.out.println("doAll");
    }

    @Override
    public void doAll() {

    }

    @Override
    public void doFirst() {

    }

    @Override
    public void atFirst() {

    }

    @Override
    public void doSecond() {

    }

    @Override
    public void atSecond() {

    }

    @Override
    public void doThird() {

    }

    @Override
    public void atThird() {

    }
}
