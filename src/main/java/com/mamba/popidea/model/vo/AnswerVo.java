package com.mamba.popidea.model.vo;

import com.mamba.popidea.model.QuestionAnswerBean;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/31 18:22
 */
public class AnswerVo extends QuestionAnswerBean {


    private String nickName;

    private String favicon;


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFavicon() {
        return favicon;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }


}