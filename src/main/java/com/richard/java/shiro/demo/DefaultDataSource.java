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

package com.richard.java.shiro.demo;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import org.logicalcobwebs.proxool.ProxoolDataSource;
import org.springframework.stereotype.Component;

/**
 * The description...
 * <p></p>
 *
 * @author Richard
 * @version 1.0.0
 */
@Component("ds-default")
public class DefaultDataSource extends ProxoolDataSource {
	public DefaultDataSource() throws IOException {
		super();
		Properties conf = new Properties();
		conf.load(this.getClass().getResourceAsStream("/conf/jdbc.properties"));
		this.setDriver(conf.getProperty("driver"));
		this.setDriverUrl(conf.getProperty("driverUrl"));
		this.setUser(conf.getProperty("user"));
		this.setPassword(conf.getProperty("password"));
		this.setAlias("alias");
		this.setHouseKeepingSleepTime(new Integer(conf
				.getProperty("houseKeepingSleepTime")));
		this.setPrototypeCount(new Integer(conf.getProperty("prototypeCount")));
		this.setMaximumConnectionCount(new Integer(conf
				.getProperty("maximumConnectionCount")));
		this.setMinimumConnectionCount(new Integer(conf
				.getProperty("minimumConnectionCount")));
		this.setSimultaneousBuildThrottle(new Integer(conf
				.getProperty("simultaneousBuildThrottle")));
		this.setMaximumConnectionLifetime(new Integer(conf
				.getProperty("maximumConnectionLifetime")));
		this.setHouseKeepingTestSql(conf.getProperty("houseKeepingTestSql"));
		this.setMaximumActiveTime(Long.parseLong(conf.getProperty("maximumActiveTime")));
	}

	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}
}
