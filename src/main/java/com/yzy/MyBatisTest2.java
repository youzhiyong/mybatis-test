package com.yzy;

import com.yzy.dao.UserDao;
import com.yzy.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Description:
 * Date: 2019-08-30
 *
 * @author youzhiyong
 */
public class MyBatisTest2 {
    public static void main(String[] args) throws IOException {

        String resPath = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resPath);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //SqlSession sqlSession = sqlSessionFactory.openSession(true);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        try {

            User user = userDao.select(50);
            System.out.println(user);

        } finally {
            sqlSession.close();
        }


    }
}
