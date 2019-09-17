package com.bksx.nettest.bean;

public class Unit {

    private String unitNum;
    private boolean isClick = false;

    public Unit(String unitNum) {
        this.unitNum = unitNum;
    }

    public String getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(String unitNum) {
        this.unitNum = unitNum;
    }

    public boolean isClick() {
        return isClick;
    }

    public void setClick(boolean click) {
        isClick = click;
    }
}
