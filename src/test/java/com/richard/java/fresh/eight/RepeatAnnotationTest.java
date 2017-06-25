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

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java 8 新特性重复注解测试类
 * <p></p>
 *
 * @author Richard
 * @version 1.0.0
 */
public class RepeatAnnotationTest {
	
	private static final Logger logger = LoggerFactory.getLogger(RepeatAnnotationTest.class);
	
	@Target( ElementType.TYPE )
	@Retention( RetentionPolicy.RUNTIME )
	public @interface Filters {
		Filter[] value();
	}
	
	@Target( ElementType.TYPE )
	@Retention(RetentionPolicy.RUNTIME )
	@Repeatable( Filters.class)
	public @interface Filter {
		String value();
	}
	
	@Filter("filter1")
	@Filter("filter2")
	public interface Filterable {
		
	}

	@Test
	public void test() {
		/*
		 * getAnnotationsByType也是Java 8中新增的方法
		 * 
		 */
		for (Filter filter : Filterable.class.getAnnotationsByType(Filter.class)) {
			logger.info(filter.value());
		}
	}

}
