package com.zy.designs.bridge;

public class HandSetBrandB extends HandSetBrand{
    public HandSetBrandB(HandSetSoft handSetSoft){
        super(handSetSoft);
    }
    public void Run(){
        soft.Run();
    }
}
