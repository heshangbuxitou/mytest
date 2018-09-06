package com.zy.designs.builder;

public class Product {
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;

    public Product(String A, String B, String C, String D, String E) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.E = E;
    }

    public void show() {
        System.out.println(A + ',' + B + ',' + C + ',' + D + ',' + E);
    }
}
