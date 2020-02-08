package com.mamba.popidea.service;

import com.mamba.popidea.model.FavColumnBean;
import com.mamba.popidea.model.UserBean;
import com.mamba.popidea.model.UserDetail;
import com.mamba.popidea.model.UserFavoriteBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.vo.FavBeanVo;
import com.mamba.popidea.model.vo.UserVO;

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

}