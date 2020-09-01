package com.ego.test;

import com.ego.entity.EasyUIPageVO;
import com.ego.entity.TbItem;
import com.ego.mapper.TbItemMapper;
import com.ego.service.TbItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-service.xml"})
public class TbItemServiceTest {
    @Autowired
    protected TbItemMapper tbItemMapper;

    @Autowired
    private TbItemService tbItemService;

    @Test
    public void getPageTbUserMapperTest() {
        int pageNum  = 0;
        int pageSize = 10;
        List<TbItem> list = tbItemMapper.selectItemPageList(pageNum, pageSize);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    @Test
    public void getPageTbUserServiceTest() {
        int pageNum  = 0;
        int pageSize = 10;
        EasyUIPageVO rows = tbItemService.list(pageNum, pageSize);
    }
}
