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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;

/**
 * The description...
 * <p></p>
 *
 * @author Richard
 * @version 1.0.0
 */
@SuppressWarnings("all")
public class DecryptDruidSource extends DruidDataSource {
	
	private static final Logger logger = LoggerFactory.getLogger(DecryptDruidSource.class);
	
	/**
	 * 重写DruidDataSource设置设置用户名密码
	 */
	@Override
	public void setUsername(String username) {
		try {
			username = ConfigTools.decrypt(username);
		} catch (Exception e) {
			logger.info("密码解密失败");
		}
		super.setUsername(username);
	}

}
