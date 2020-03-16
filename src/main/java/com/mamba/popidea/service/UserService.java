package com.mamba.popidea.service;

import com.mamba.popidea.model.*;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.vo.*;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/20 22:55
 */

public interface UserService {

    void register(UserBean userBean);

    String login(String username, String password);

    boolean loginOut(String token);

    void detailInfoEdit(UserDetail userDetail);

    UserVO geWholeUserInfo();

    RestData<FavColumnBean> getUserFavColumnList(Integer pageNo, Integer pageSize);

    RestData<FavBeanVo> getUserFavList(Long columnId, Integer pageNo, Integer pageSize);

    RestData<AttentionPersonVO> getMyAttentionPersonList(Integer pageNo, Integer pageSize);

    RestData<AttentionQuestionVO> getMyAttentionQuestionList(Integer pageNo, Integer pageSize);

    RestData<AttentionColumnVO> getMyAttentionColumnList(Integer pageNo, Integer pageSize);

    RestData<QuestionBean> getCreatedQuestionList(Integer pageNo, Integer pageSize);

    RestData<SpecialColumnBean> getCreatedColumnList(Integer pageNo, Integer pageSize);

    RestData<OwnAnswerVo> getCreatedAnswerList(Integer pageNo, Integer pageSize);

    RestData getUserSearch(String keyword, Integer pageNo, Integer pageSize);
}