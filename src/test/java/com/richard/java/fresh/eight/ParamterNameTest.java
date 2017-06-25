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

package com.richard.java.fresh.eight;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java 8 新特性编译器保留参数名称测试类
 * 
 * <p></p>
 *
 * @author Richard
 * @version 1.0.0
 */
public class ParamterNameTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ParamterNameTest.class);

	/**
	 * 测试Java 8编译器中是否保留参数名称
	 * 
	 * @param values     参数
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	@Test
	public void testParamterName(String[] values) throws NoSuchMethodException, SecurityException {
		Method method = ParamterNameTest.class.getMethod("testParamterName", String[].class);
		
		for (final Parameter parameter : method.getParameters()) {
			logger.info("Parameter: " + parameter);
		}
	}
	
	/**
	 * 测试Java 8 编译器保留参数名称
	 * @param args     参数
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Method method = ParamterNameTest.class.getMethod("main", String[].class);
		
		for (final Parameter parameter : method.getParameters()) {
			logger.info("Parameter: " + parameter);
		}
	}

}
