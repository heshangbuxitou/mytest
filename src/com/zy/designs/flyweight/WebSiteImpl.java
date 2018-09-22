package com.zy.designs.flyweight;

public class WebSiteImpl implements WebSite{
    public String name;

    public WebSiteImpl(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void Use(User user) {
        System.out.println("网站分类:" + name + ",用户名：" + user.name);
    }
}
