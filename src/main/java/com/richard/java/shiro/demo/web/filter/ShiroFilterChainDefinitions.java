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

package com.richard.java.shiro.demo.web.filter;

import java.text.MessageFormat;
import java.util.List;

import org.apache.shiro.config.Ini;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.richard.java.shiro.demo.auth.service.IAuthService;
import com.richard.java.shiro.demo.base.AuthType;
import com.richard.java.shiro.demo.base.model.AuthMap;

/**
 * The description...
 * <p></p>
 *
 * @author Richard
 * @version 1.0.0
 */
public class ShiroFilterChainDefinitions implements FactoryBean<Ini.Section> {

    @Autowired
    private IAuthService authService;

    private String filterChainDefinitions;

    public IAuthService getAuthService() {
        return authService;
    }

    public void setAuthService(IAuthService authService) {
        this.authService = authService;
    }

    public String getFilterChainDefinitions() {
        return filterChainDefinitions;
    }

    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    public static final String PREMISSION_STRING = "perms[{0}]";

    public static final String ROLE_STRING = "roles[{0}]";

    public Ini.Section getObject() throws Exception {
        List<AuthMap> list = this.getAuthService().getFilterChainDefinitions();
        Ini ini = new Ini();
        ini.load(this.getFilterChainDefinitions());
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        for (AuthMap map : list) {
            String s = null;
            switch (AuthType.valueOf(map.getAuthcType())) {
                case roles:
                    s = MessageFormat.format(ROLE_STRING, map.getVal());
                    break;
                case perms:
                    s = MessageFormat.format(PREMISSION_STRING, map.getVal());
                    break;
                case authc:
                    s = AuthType.authc.name();
                case anon:
                    s = AuthType.anon.name();
                default:
                    s = AuthType.authc.name();
            }
            section.put(map.getUrl(), s);
        }
        return section;
    }

    public Class<?> getObjectType() {
        return this.getClass();
    }

    public boolean isSingleton() {
        return false;
    }
}
