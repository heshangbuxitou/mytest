package com.zy.designs.flyweight;

import java.util.HashMap;
import java.util.Map;

public class WebSiteFactory {
    public Map<String, WebSite> flyweights = new HashMap();

    public WebSite getWebSiteCategory(String key) {
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new WebSiteImpl(key));
        }
        return flyweights.get(key);
    }

    public int getWebSiteTotal() {
        return flyweights.size();
    }
}
