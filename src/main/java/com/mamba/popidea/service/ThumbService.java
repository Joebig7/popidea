package com.mamba.popidea.service;

import com.mamba.popidea.model.vo.ThumbVo;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/11/11 18:02
 * @description
 */
public interface ThumbService {

    void thumb(Long userId, Long targetId, Integer type, Integer status);

    ThumbVo getThumbData(Long targetId, Integer type);

}