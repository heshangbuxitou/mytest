package com.zy.designs.flyweight;

public class Main {
    public static void main(String[] args) {
        /**
         * 享元模式的作用是 分享有相同属性和方法的实例，他可以避免大量非常相似类的开销，
         * 在软件开发过程中，有一些类都是相似的，我们可以把这些类中不同的参数移到实例的
         * 外面，在方法调用时在将他们传递进来，这样可以实现实例的复用。享元模式和缓存有点
         * 相似，但是思想上是不同的。下面通过网站的例子来演示享元模式。
         */
        User user = new User("小李");

        WebSiteFactory wsf = new WebSiteFactory();
        WebSite webSite = wsf.getWebSiteCategory("产品展示");
        webSite.Use(user);
        WebSite webSite2 = wsf.getWebSiteCategory("产品展示");
        webSite2.Use(user);
        WebSite webSite3 = wsf.getWebSiteCategory("产品展示");
        webSite3.Use(user);

        User use2 = new User("小黄");
        WebSite webSitex = wsf.getWebSiteCategory("博客");
        webSitex.Use(use2);
        WebSite webSitey = wsf.getWebSiteCategory("博客");
        webSitey.Use(use2);
        WebSite webSitez = wsf.getWebSiteCategory("博客");
        webSitez.Use(use2);

        System.out.println("网站分类总数为:" + wsf.getWebSiteTotal());
    }
}
