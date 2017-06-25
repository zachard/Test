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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java 8 新增类 Optional测试
 * <p></p>
 *
 * @author Richard
 * @version 1.0.0
 */
public class OptionalTest {
	
	private static final Logger logger = LoggerFactory.getLogger(OptionalTest.class);

	/**
	 * 测试Optional判断是否为null值
	 */
	@Test
	public void testOptionalUse() {
//		Optional<String> fullName = Optional.of("richard");
		
		//当传入ofNullable中的对象为null时，返回一个空的Optional，否则返回一个描述该non-null值的Optional
		Optional<String> fullName = Optional.ofNullable(null);
		
		//isPresent判断Optional是否存在值，存在为true，否则返回false
		logger.info("Full Name is set ? " + fullName.isPresent());
		
		//orElseGet当Optional存在值时，则返回该值，否则执行方法中的Lambda表达式，并返回该值
		logger.info("Full Name: " + fullName.orElseGet( () -> "[None]") );
		
		/*
		 * map函数当值存在时，将map中提供的Lambda应用到该值
		 * 并且如果Lambda表达式计算的结果不为空，则返回该值描述的Optional
		 * 如果Lambda表达式计算的结果为空，则返回一个空的Optional
		 * 
		 * orElse方法判断Optional中值是否为空，不为空返回该值，为空时则返回方法参数对象
		 */
		logger.info(fullName.map( s -> "Hey " + s +"!").orElse("Hey Stranger!"));
		
		List<String> nameList = Arrays.asList("Amy", "Bob", "Cary");
		List<String> value = Optional.ofNullable(nameList).orElse(Arrays.asList());
		logger.info("List长度为: " + value.size());
	}

}
