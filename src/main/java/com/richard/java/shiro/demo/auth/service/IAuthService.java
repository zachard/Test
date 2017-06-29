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

package com.richard.java.shiro.demo.auth.service;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;

import com.richard.java.shiro.demo.base.model.AuthMap;

/**
 * 权限认证业务层接口
 * 
 * <p></p>
 *
 * @author Richard
 * @version 1.0.0
 */
public interface IAuthService {
	
	/**
     * 用户登录接口
     * @param userName 登录用户名
     * @param password 密码
     * @throws AuthenticationException
     */
    void login(String userName, String password) throws AuthenticationException;

    /**
     * 用户登出系统
     */
    void logout();

    /**
     * 获得数据库中存储的访问控制数据
     * @return
     */
    List<AuthMap> getFilterChainDefinitions();
    
}
