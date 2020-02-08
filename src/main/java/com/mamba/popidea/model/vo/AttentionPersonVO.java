package com.mamba.popidea.model.vo;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/8 16:26
 * @description
 */
public class AttentionPersonVO {
    private Long id;
    private String nickName;
    private String description;
    private String favicon;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFavicon() {
        return favicon;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}