package com.zy.test;

import com.zy.build.BuildUser;
import com.zy.domain.Items;
import com.zy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class MyBatisTest {
    private SqlSessionFactory sqlSessionFactory;
    private BuildUser buildUser;

    @Before
    public void init() throws IOException {
        String resource = "SqlMapConfig.xml";
        // 加载配置文件到输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        buildUser = new BuildUser();
    }

    @Test
    public void testFindUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        try {
            Logger.getAnonymousLogger().info(sqlSession.selectOne("test.findUserById", 1).toString());
            Logger.getAnonymousLogger().info(sqlSession.selectOne("test.findUserById", 1).toString());
            Logger.getAnonymousLogger().info(sqlSession.selectOne("test.findUserById", 1).toString());
            int num = sqlSession.insert("test.insertUser", buildUser.buildUser());
            Logger.getAnonymousLogger().info("新增加" + num + "个用户");
            sqlSession.delete("test.deleteUserById", 10);
            Logger.getAnonymousLogger().info(sqlSession.selectOne("test.findUserById", 1).toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
            sqlSession2.close();
        }
    }


    @Test
    public void testFindUserByIdItems() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        try {
            Logger.getAnonymousLogger().info(sqlSession.selectOne("test.findUserById", 1).toString());
            sqlSession.commit();
            Logger.getAnonymousLogger().info(sqlSession2.selectOne("test.findUserById", 1).toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
            sqlSession2.close();
        }
    }
}
