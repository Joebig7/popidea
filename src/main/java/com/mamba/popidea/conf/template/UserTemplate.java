package com.mamba.popidea.conf.template;

import com.mamba.popidea.utils.FastJsonUtil;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/6/18 17:05
 * @description
 */
public class UserTemplate {

    private String name = "匿名用户";
    private String favicon = "www.xxxx.com";

    public UserTemplate() {

    }

    public UserTemplate(String name, String favicon) {
        this.name = name;
        this.favicon = favicon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavicon() {
        return favicon;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }
}