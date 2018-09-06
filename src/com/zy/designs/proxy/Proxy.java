package com.zy.designs.proxy;

public class Proxy implements GiveGift {
    Pursuit pursuit;

    public Proxy(SchoolGirl girl) {
        pursuit = new Pursuit(girl);
    }

    @Override
    public void GiveDolls() {
        pursuit.GiveDolls();
    }

    @Override
    public void GiveFlower() {
        pursuit.GiveFlower();
    }

    @Override
    public void GiveChocolate() {
        pursuit.GiveChocolate();
    }
}
