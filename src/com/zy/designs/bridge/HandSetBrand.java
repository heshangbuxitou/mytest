package com.zy.designs.bridge;

public abstract class HandSetBrand {
    public HandSetSoft soft;

    public HandSetSoft getSoft() {
        return soft;
    }

    public void setSoft(HandSetSoft soft) {
        this.soft = soft;
    }

    public HandSetBrand(HandSetSoft handSetSoft) {
        soft = handSetSoft;
    }

    public abstract void Run();
}
