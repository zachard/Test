/*
 *  Copyright 2015-2017 Richard, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.richard.java.shiro.demo.auth.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.richard.java.shiro.demo.auth.dao.IAuthDao;
import com.richard.java.shiro.demo.base.BaseDao;
import com.richard.java.shiro.demo.base.model.AuthMap;
import com.richard.java.shiro.demo.base.model.User;

/**
 * The description...
 * <p></p>
 *
 * @author Richard
 * @version 1.0.0
 */
@SuppressWarnings("all")
@Component("authDao")
public class AuthDao extends BaseDao implements IAuthDao {
    @Autowired
    public AuthDao(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public User findByName(String name) {
        Criteria cri = this.getSessionFactory().getCurrentSession().createCriteria(User.class);
        cri.add(Restrictions.eq("username", name));
        List<User> list = cri.list();
        return list != null && list.size() > 0 ? list.get(0) : null;
    }

    public List<AuthMap> getAllAuthcMap() {
        Criteria cri = this.getSessionFactory().getCurrentSession().createCriteria(AuthMap.class);
        return cri.list();
    }
}
