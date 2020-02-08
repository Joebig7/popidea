package com.mamba.popidea.service;

import com.mamba.popidea.model.UserAttentionBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.vo.AttentionQuestionVO;
import com.mamba.popidea.model.vo.AttentionColumnVO;
import com.mamba.popidea.model.vo.AttentionPersonVO;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/11/15 18:06
 */
public interface AttentionService {

    void toggle(UserAttentionBean userAttentionBean);


    RestData<AttentionPersonVO> getAttentionPersonList(Long userId, Integer pageNo, Integer pageSize);

    RestData<AttentionQuestionVO> getAttentionQuestionList(Long userId, Integer pageNo, Integer pageSize);

    RestData<AttentionColumnVO> getAttentionColumnList(Long userId, Integer pageNo, Integer pageSize);
}