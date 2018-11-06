package com.bksx.nettest.testclass;

import javax.inject.Inject;

public class DraggerA {
    DraggerB draggerB;
    DraggerC draggerC;

    @Inject

    public DraggerA(DraggerB draggerB ) {
        this.draggerB = draggerB;
    }
}
