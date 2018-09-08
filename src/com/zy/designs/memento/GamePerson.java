package com.zy.designs.memento;

public class GamePerson {
    private int vit;
    private int atk;
    private int def;

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public RoleStateMemento saveState() {
        return new RoleStateMemento(vit, atk, def);
    }

    public void rocoveryState(RoleStateMemento memento) {
        this.vit = memento.Vitality;
        this.atk = memento.Attack;
        this.def = memento.Defence;
    }

    public void initState() {
        vit = 100;
        atk = 100;
        def = 100;
    }

    public void fight() {
        vit = 0;
        atk = 0;
        def = 0;
    }

    public void show() {
        System.out.println("角色当前的状态: ");
        System.out.println("体力:" + vit);
        System.out.println("攻击力:" + atk);
        System.out.println("防御力:" + def);
    }
}
