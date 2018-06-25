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

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The description...
 * <p></p>
 *
 * @author Richard
 * @version 1.0.0
 */
public class AppTest {

	@Test
	public void testApp() throws SQLException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:conf/*-beans.xml");
		DataSource ds = (DataSource) ctx.getBean("ds-default");
        Connection con = ds.getConnection();
        con.close();
        assertTrue(true);
	}

}
