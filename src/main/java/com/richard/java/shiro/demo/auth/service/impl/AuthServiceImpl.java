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

package com.richard.java.shiro.demo.auth.service.impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.richard.java.shiro.demo.auth.dao.IAuthDao;
import com.richard.java.shiro.demo.auth.service.IAuthService;
import com.richard.java.shiro.demo.base.model.AuthMap;

/**
 * The description...
 * <p></p>
 *
 * @author Richard
 * @version 1.0.0
 */
@Service("authSvr")
public class AuthServiceImpl implements IAuthService {

    public IAuthDao getAuthDao() {
        return authDao;
    }

    public void setAuthDao(IAuthDao authDao) {
        this.authDao = authDao;
    }

    @Autowired
    private IAuthDao authDao;

    @Override
    public void login(String userName, String password) throws AuthenticationException {
        UsernamePasswordToken token= new UsernamePasswordToken(userName,password);
        SecurityUtils.getSubject().login(token);
    }

    @Override
    public void logout() {
        SecurityUtils.getSubject().logout();
    }

    public List<AuthMap> getFilterChainDefinitions() {
        return this.getAuthDao().getAllAuthcMap();
    }
}
