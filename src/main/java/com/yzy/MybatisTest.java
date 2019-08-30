package com.yzy;

import com.yzy.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Description:
 * Date: 2019-08-29
 *
 * @author youzhiyong
 */
public class MybatisTest {

    public static void main(String[] args) throws IOException {

        String resPath = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resPath);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();


        try {
            // 这里用 com.yzy.dao.UserDao.select 或者 select 作为key都可以，
            //@see Configuration.getMappedStatement() 方法   mappedStatements 属性里面保存了
            User user = sqlSession.selectOne("com.yzy.dao.UserDao.select", 50);
            System.out.println(user);

            User user1 = new User(50, "CCC");
            int res = sqlSession.update("update", user1);
            System.out.println(res);

            User user2 = new User(3, "youzhiyong");
            int i = sqlSession.insert("com.yzy.dao.UserDao.insert", user2);
            System.out.println(i);

            sqlSession.commit();  //需要手动commit

        } finally {
            sqlSession.close();
        }


    }

}
