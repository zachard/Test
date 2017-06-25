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

import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java8默认方法测试
 * 
 * <p>要求接口为默认方法提供一个默认实现</p>
 *
 * @author Richard
 * @version 1.0.0
 */
public interface DefaultAndStaticMethodInterface {
	
	Logger logger = LoggerFactory.getLogger(DefaultAndStaticMethodInterface.class);
	
	/**
	 * Java 8 新增默认方法
	 * 
	 * @return   说明
	 */
	default String defaultMethod() {
		return "This is a Java 8 default method";
	}
	
	/**
	 * Java 8 新增接口静态方法
	 * 
	 * @param supplier  接口静态方法参数
	 * @return          接口静态方法返回值
	 */
	static DefaultAndStaticMethodInterface instance(Supplier<DefaultAndStaticMethodInterface> supplier) {
		return supplier.get();
	}
	
	/**
	 * 默认方法接口的默认实现，默认继承default方法
	 * 
	 * @author richard
	 *
	 */
	class DefaultableImpl implements DefaultAndStaticMethodInterface {
		
	}
	
	/**
	 * 覆写默认方法接口的实现
	 * 
	 * @author richard
	 *
	 */
	class OverridableImpl implements DefaultAndStaticMethodInterface {
		
		/**
		 * 接口默认方法的覆写
		 */
		@Override
		public String defaultMethod() {
			return "This is a override implement";
		}
	}
	
	/**
	 * main测试方法
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DefaultAndStaticMethodInterface defaultable = instance(DefaultableImpl::new);
		logger.info(defaultable.defaultMethod());
		
		defaultable = instance(OverridableImpl::new);
		logger.info(defaultable.defaultMethod());
	}
}
