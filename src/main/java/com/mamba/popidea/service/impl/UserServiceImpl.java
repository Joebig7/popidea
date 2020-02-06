package com.mamba.popidea.service.impl;

import com.google.common.collect.Maps;
import com.mamba.popidea.dao.UserBeanMapper;
import com.mamba.popidea.dao.UserDetailMapper;
import com.mamba.popidea.dao.UserFavoriteBeanMapper;
import com.mamba.popidea.dao.UserIntergralBeanMapper;
import com.mamba.popidea.exception.ErrorCodes;
import com.mamba.popidea.exception.ServiceException;
import com.mamba.popidea.model.UserBean;
import com.mamba.popidea.model.UserDetail;
import com.mamba.popidea.model.UserFavoriteBean;
import com.mamba.popidea.model.UserIntergralBean;
import com.mamba.popidea.model.common.project.Audience;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.vo.UserVO;
import com.mamba.popidea.service.UserService;
import com.mamba.popidea.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Objects;

import static com.mamba.popidea.constant.ServiceTypeEnum.UserStatus;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/20 22:55
 */

@Service
public class UserServiceImpl implements UserService {

    private static Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private Audience audience;

    @Autowired
    private UserBeanMapper userBeanMapper;

    @Autowired
    private EmailTool emailTool;

    @Autowired
    private TemplateTool templateTool;

    @Autowired
    private UserIntergralBeanMapper userIntergralBeanMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserDetailMapper userDetailMapper;

    private UserFavoriteBeanMapper userFavoriteBeanMapper;

    @Transactional
    @Override
    public void register(UserBean userBean) {
        try {
            userBean.setStatus(UserStatus.NORMAL.getStatus());
            userBeanMapper.insertSelective(userBean);
            initIntegral(userBean);
            sendEmail(userBean);
        } catch (Exception e) {
            log.info("用户注册有问题");
            throw ServiceException.newInstance(ErrorCodes.REGISTER_FAILURE_ERROR);
        }
    }

    private void sendEmail(UserBean userBean) throws Exception {
        Map<String, Object> map = Maps.newHashMap();
        map.put("name", userBean.getNickName());
        emailTool.send(templateTool.render("html/register", map), userBean.getEmail());
    }

    private void initIntegral(UserBean userBean) {
        UserIntergralBean userIntergralBean = new UserIntergralBean(userBean.getId());
        userIntergralBeanMapper.insertSelective(userIntergralBean);
    }

    @Transactional
    @Override
    public String login(String username, String password) {

        UserBean userBean = checkUserExist(username);

        if (Objects.isNull(userBean)) {
            throw ServiceException.newInstance(ErrorCodes.USER_NULL_ERROR);
        }

        if (password.equals(userBean.getPassword())) {
            String token = JwtUtil.createJWT(userBean, audience);
            return token;
        } else {
            throw ServiceException.newInstance(ErrorCodes.USER_PASSWORD_ERROR);
        }

    }

    private UserBean checkUserExist(String username) {
        return userBeanMapper.selectUserByLoginName(username);
    }

    private void cacheTokenToRedis(String token, UserBean userBean, Long expireTime) {
        userBean.setPassword(null);
        redisUtil.add(token, FastJsonUtil.toJSONString(userBean), expireTime);
    }

    @Override
    public boolean loginOut(String token) {
        if (token == null) {
            throw ServiceException.newInstance(ErrorCodes.TOKEN_CHECKED_ERROR);
        }
        if (!redisUtil.isKeyExist(token)) {
            throw ServiceException.newInstance(ErrorCodes.TOKEN_CHECKED_ERROR);
        } else {
            return redisUtil.delete(token.substring(7).trim());
        }
    }

    @Override
    public void detailInfoEdit(UserDetail userDetail) {
        Long userId = CommonUtil.getUserId();
        userDetail.setUserId(userId);
        if (Objects.isNull(userDetailMapper.selectUserDetailByUserId(userId))) {
            userDetailMapper.insertSelective(userDetail);
        } else {
            userDetailMapper.updateByPrimaryKey(userDetail);
        }
    }

    /**
     * 获取用户的完整信息
     *
     * @return
     */
    @Override
    public UserVO geWholeUserInfo() {
        Long userId = CommonUtil.getUserId();
        return userBeanMapper.findWholeUserInfoById(userId);
    }

    /**
     * 获取用户的收藏列表
     *
     * @return
     */
    @Override
    public RestData<UserFavoriteBean> getUserFavList() {
        Long userId = CommonUtil.getUserId();
        userFavoriteBeanMapper.getUserFavList(userId);
        return null;
    }

    protected UserBean findUserById(Long userId) {
        return userBeanMapper.selectByPrimaryKey(CommonUtil.getUserId());
    }
}