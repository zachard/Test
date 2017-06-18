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

package com.richard.java.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The description...
 * <p></p>
 *
 * @author Richard
 * @version 1.0.0
 */
public class Tutorial {
	
	private static final transient Logger log = LoggerFactory.getLogger(Tutorial.class);
	
	public static void main(String[] agrs) {
		log.info("我的第一个Shiro程序");
		
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		session.setAttribute("name", "richard");
		String value = (String) session.getAttribute("name");
		if (value.equals("richard")) {
			log.info("正确的输入值! + [" + value + "]");
		}
		
		// let's login the current user so we can check against roles and permissions:
        if (!subject.isAuthenticated()) {
        	//这里的用户名和密码必须是在shiro.ini文件中配置的(因为SecurityManager是基于该文件创建)
            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
            token.setRememberMe(true);
            log.info("是否记住了：" + subject.isRemembered());
            log.info("当前会话是否通过认证：" + subject.isAuthenticated());
            try {
            	subject.login(token);
            } catch (UnknownAccountException uae) {
                log.info("用户名不存在 " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {
                log.info("密码错误 " + token.getPrincipal() + " was incorrect!");
            } catch (LockedAccountException lae) {
                log.info("账户 " + token.getPrincipal() + " 被锁定  " +
                        "请联系管理员进行解锁.");
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            }
        }
        
        log.info("是否记住了：" + subject.isRemembered());
        log.info("当前会话是否通过认证：" + subject.isAuthenticated());
        
        //say who they are:
        //print their identifying principal (in this case, a username):
        log.info("用户 [" + subject.getPrincipal() + "] 成功登录.");
        
        //test a role:
        if (subject.hasRole("schwartz")) {
            log.info("用户属于schwartz角色!");
        } else {
            log.info("用户不属于schwartz角色!");
        }
		
        //test a typed permission (not instance-level)
        if (subject.isPermitted("lightsaber:wield")) {
            log.info("You may use a lightsaber ring.  Use it wisely.");
        } else {
            log.info("Sorry, lightsaber rings are for schwartz masters only.");
        }

        //a (very powerful) Instance Level permission:
        if (subject.isPermitted("winnebago:drive:eagle5")) {
            log.info("You are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  " +
                    "Here are the keys - have fun!");
        } else {
            log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
        }
        
        subject.logout();
        
        //判断用户登出之后调用对应方法返回值(拿到的值为null)
        log.info("用户 [" + subject.getPrincipal() + "] 成功登录.");
        
        //用户登出后的角色判断(难道这就是传说中的游客?)
        if (subject.hasRole("schwartz")) {
            log.info("用户属于schwartz角色!");
        } else {
            log.info("用户不属于schwartz角色!");
        }
        
		System.exit(0);
	}

}
