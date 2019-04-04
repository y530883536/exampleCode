package com.zero.local.designPattern.adapter.objectAdapter;

public class Adapter implements Saber {

    private AK47 ak47;

    public Adapter(AK47 ak47){
        this.ak47 = ak47;
    }

    @Override
    public void chop() {
        ak47.fire();
    }
}
