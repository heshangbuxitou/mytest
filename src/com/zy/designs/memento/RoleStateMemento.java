package com.zy.designs.memento;

public class RoleStateMemento {
    public int Vitality;
    public int Attack;
    public int Defence;

    public RoleStateMemento(int vit, int atk, int def) {
        Vitality = vit;
        Attack = atk;
        Defence = def;
    }
}
