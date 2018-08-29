package com.bksx.nettest.bean;

import com.bksx.nettest.testpackage.TestInterface;

import java.util.ArrayList;
import java.util.List;

public class Person implements TestInterface{
    private String name;
    private List<Plan> planList = new ArrayList<>();
    public Person(String name, List<Plan> planList) {
        this.name = name;
        this.planList = planList;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Plan> getPlanList() {
        return planList;
    }
    public void setPlanList(List<Plan> planList) {
        this.planList = planList;
    }

    @Override
    public void test1() {

    }

    @Override
    public void test2() {

    }

    @Override
    public void test3() {

    }
}