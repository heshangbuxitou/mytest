package com.zy.designs.builder;

public class Builder {
    private String A = null;
    private String B = null;
    private String C = null;
    private String D = null;
    private String E = null;

    public Builder setA(String a) {
        A = a;
        return this;
    }

    public Builder setB(String b) {
        B = b;
        return this;
    }

    public Builder setC(String c) {
        C = c;
        return this;
    }

    public Builder setD(String d) {
        D = d;
        return this;
    }

    public Builder setE(String e) {
        E = e;
        return this;
    }

    public Product getResult() {
        return new Product(A, B, C, D, E);
    }
}
