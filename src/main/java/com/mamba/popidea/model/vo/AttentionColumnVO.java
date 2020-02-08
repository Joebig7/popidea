package com.mamba.popidea.model.vo;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/8 16:28
 * @description
 */
public class AttentionColumnVO {

    private Long id;
    private String title;
    private String introduction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}