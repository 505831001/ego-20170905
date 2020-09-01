package com.ego.test;

import com.ego.entity.TbUser;
import com.ego.mapper.TbUserMapper;
import com.ego.service.TbUserService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-service.xml"})
public class TbUserServiceTest {

    private ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:spring-service.xml");

    @Test
    public void springConnectDBTest() {
        System.out.println("ClassPathXml: " + ctx);
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("IoC -> " + name);
        }
        int count = ctx.getBeanDefinitionCount();
        System.out.println("IoC count -> " + count);
    }

    @Test
    public void tbUserServiceTest() {
        TbUserMapper mapper = ctx.getBean(TbUserMapper.class);
        List<TbUser> tbUserList = mapper.selectAll();
        for (TbUser tbUser : tbUserList) {
            System.out.println(tbUser.toString());
        }

        TbUserService tbUserService = ctx.getBean(TbUserService.class);
        List<TbUser> tbUserList2 = tbUserService.getAll();
        for (TbUser tbUser : tbUserList2) {
            System.out.println(tbUser.toString());
        }
    }

    @Autowired
    private TbUserService tbUserService;

    @Test
    public void getPageTbUser() {
        int pageNum  = 0;
        int pageSize = 4;
        PageInfo<TbUser> pageInfo = tbUserService.getPageTbUser(pageNum, pageSize);
        System.out.println(pageInfo);
    }
}
