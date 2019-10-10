package com.mamba.popidea.service;

import com.mamba.popidea.model.UserBean;
import com.mamba.popidea.model.UserDetail;
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
}