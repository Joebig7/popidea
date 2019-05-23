package com.mamba.popidea.service;

import com.mamba.popidea.dao.UserBeanMapper;
import com.mamba.popidea.model.UserBean;
import com.mamba.popidea.model.UserDetail;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

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

}