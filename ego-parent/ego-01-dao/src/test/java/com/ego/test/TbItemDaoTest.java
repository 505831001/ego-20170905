package com.ego.test;

import com.ego.entity.TbItem;
import com.ego.mapper.TbItemMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-dao.xml"})
public class TbItemDaoTest {
    @Autowired
    private TbItemMapper tbItemMapper;

    @Test
    public void getCountTest() {
        long count = tbItemMapper.count();
        System.out.println(count);
    }

    @Test
    public void getPageTbItemTest() {
        int pageNum  = 0;
        int pageSize = 100;
        List<TbItem> list = tbItemMapper.selectItemPageList(pageNum, pageSize);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }
}
