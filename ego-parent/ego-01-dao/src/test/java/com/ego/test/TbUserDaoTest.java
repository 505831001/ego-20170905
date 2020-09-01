package com.ego.test;

import com.ego.mapper.TbUserMapper;
import com.ego.entity.TbUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-dao.xml"})
public class TbUserDaoTest {
    @Autowired
    protected TbUserMapper tbUserMapper;

    /**
     * 通过MyBatis方式获取数据库连接
     *
     * @throws IOException
     */
    @Test
    public void mybatisConnectDBTest() throws IOException {
        InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(config);
        SqlSession session = factory.openSession();
        System.out.println("Link ->" + session);
    }

    private ClassPathXmlApplicationContext  ctx1 = new ClassPathXmlApplicationContext("classpath:spring-dao.xml");
    private FileSystemXmlApplicationContext ctx2 = new FileSystemXmlApplicationContext("file:src/main/resources/spring-dao.xml");

    /**
     * 通过类路径和文件路径获取IoC容器
     */
    @Test
    public void springConnectDBTest() {
        System.out.println("ClassPathXml:  " + ctx1);
        System.out.println("FileSystemXml: " + ctx2);
        String[] names = ctx1.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("IoC -> " + name);
        }
        int count = ctx1.getBeanDefinitionCount();
        System.out.println("IoC count -> " + count);
    }

    /**
     * 通过MyBatis获取数据库数据
     *
     * @throws IOException
     */
    @Test
    public void tbUserMyBatisTest() throws IOException {
        InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(config);
        SqlSession session = factory.openSession();

        TbUserMapper mapper = session.getMapper(TbUserMapper.class);
        List<TbUser> tbUserList = mapper.selectAll();
        System.out.println(tbUserList.toString());
    }

    /**
     * 通过映射接口和XML组合获取数据库数据
     */
    @Test
    public void tbUserMapperTest() {
        List<TbUser> list = tbUserMapper.selectAll();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }
}
