package com.mamba.popidea.model.vo;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/11/12 11:45
 * @description
 */
public class ThumbVo {

    private Long upCount;
    private Long downCount;

    public ThumbVo() {

    }

    public ThumbVo(Long upCount, Long downCount) {
        this.upCount = upCount;
        this.downCount = downCount;
    }

    public Long getUpCount() {
        return upCount;
    }

    public void setUpCount(Long upCount) {
        this.upCount = upCount;
    }

    public Long getDownCount() {
        return downCount;
    }

    public void setDownCount(Long downCount) {
        this.downCount = downCount;
    }

    @Override
    public String toString() {
        return "ThumbVo{" +
                "upCount=" + upCount +
                ", downCount=" + downCount +
                '}';
    }
}