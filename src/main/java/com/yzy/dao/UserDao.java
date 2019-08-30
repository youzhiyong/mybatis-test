package com.yzy.dao;

import com.yzy.entity.User;

/**
 * Description:
 * Date: 2019-08-30
 *
 * @author youzhiyong
 */
public interface UserDao {

    User select(int id);

    int insert(User user);

    int update(User user);

}
