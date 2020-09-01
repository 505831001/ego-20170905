package com.ego.test;

import com.ego.entity.EasyUIPageVO;
import com.ego.entity.TbItem;
import com.ego.entity.TbItemParam;
import com.ego.mapper.TbItemMapper;
import com.ego.mapper.TbItemParamMapper;
import com.ego.service.TbItemParamService;
import com.ego.service.TbItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-service.xml"})
public class TbItemParamServiceTest {
    @Autowired
    protected TbItemParamMapper tbItemParamMapper;

    @Autowired
    private TbItemParamService tbItemParamService;

    @Test
    public void getTbItemMapperTest() {
        int pageNum  = 0;
        int pageSize = 10;
        List<TbItemParam> list = tbItemParamMapper.selectItemPageList(pageNum, pageSize);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }

        List<TbItemParam> rows = tbItemParamService.query();
        for (int i = 0; i < rows.size(); i++) {
            System.out.println(rows.get(i).toString());
        }
    }

    @Test
    public void getTbItemServiceTest() {
        int pageNum  = 0;
        int pageSize = 10;
        EasyUIPageVO easyUIPageVO = tbItemParamService.list(pageNum, pageSize);
        List<?> rows = easyUIPageVO.getRows();
        for (int i = 0; i < rows.size(); i++) {
            System.out.println("总共有多少行呀？" + rows.get(i));
        }
        long count = easyUIPageVO.getTotal();
        System.out.println("总共有多少呀？" + count);
    }
}
