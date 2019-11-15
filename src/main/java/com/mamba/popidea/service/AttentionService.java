package com.mamba.popidea.service;

import com.mamba.popidea.model.UserAttentionBean;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/11/15 18:06
 */
public interface AttentionService {

    void toggle(UserAttentionBean userAttentionBean);
}