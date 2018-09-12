package com.zy.designs.bridge;

public class HandSetBrandA extends HandSetBrand {
    public HandSetBrandA(HandSetSoft handSetSoft){
        super(handSetSoft);
    }
    public void Run(){
        soft.Run();
    }
}
