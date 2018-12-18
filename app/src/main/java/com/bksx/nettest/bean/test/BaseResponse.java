package com.bksx.nettest.bean.test;

public class BaseResponse <T>{

    ReturnData<T> returnData;

    public ReturnData<T> getReturnData() {
        return returnData;
    }

    public void setReturnData(ReturnData<T> returnData) {
        this.returnData = returnData;
    }


}
