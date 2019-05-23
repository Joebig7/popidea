package com.mamba.popidea;

import com.mamba.popidea.dao.UserBeanMapper;
import com.mamba.popidea.model.UserBean;
import com.mamba.popidea.utils.EmailTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PopideaApplicationTests {

	@Autowired
	private UserBeanMapper userBeanMapper;

	@Test
	public void contextLoads() {
		UserBean zjf = userBeanMapper.selectUserByLoginName("zjf");
		System.out.println(zjf);
	}

	@Test
	public void sendEmail(){
		EmailTool emailTool = new EmailTool();
		emailTool.send("hello","927418208@qq.com");
	}

}
