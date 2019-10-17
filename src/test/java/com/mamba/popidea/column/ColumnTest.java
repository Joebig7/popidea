package com.mamba.popidea.column;

import com.mamba.popidea.constant.ServiceTypeEnum;
import com.mamba.popidea.model.SpecialColumnBean;
import com.mamba.popidea.service.SpecialColumnService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/16 18:11
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ColumnTest {


    @Autowired
    private SpecialColumnService specialColumnService;

    @Test
    public void testCreateOrUpdate() {
        //add
        SpecialColumnBean columnBean = new SpecialColumnBean();
        columnBean.setStatus(ServiceTypeEnum.ColumnStatus.NORMAL.status);
        columnBean.setUserId(10001L);
        columnBean.setIntroduction("this is my first column");
        columnBean.setTitle("column 1");
        specialColumnService.createOrUpdate(columnBean);
    }

    @Test
    public void testCreateOrUpdate2() {
        //update
        SpecialColumnBean columnBean = new SpecialColumnBean();
        columnBean.setId(1L);
        columnBean.setIntroduction("this is my first column-update");
        columnBean.setTitle("column 1-update");
        specialColumnService.createOrUpdate(columnBean);
    }


    @Test
    public void testDelete() {
        specialColumnService.delete(1L);
    }

}