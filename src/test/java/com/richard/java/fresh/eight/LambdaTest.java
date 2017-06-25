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

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 此测试类方法用于测试Java8的Lambda表达式的新特性
 * 
 * <p></p>
 *
 * @author Richard
 * @version 1.0.0
 */
public class LambdaTest {
	
	private static final Logger logger = LoggerFactory.getLogger(LambdaTest.class);

	/**
	 * 测试Lambda遍历集合
	 */
	@Test
	public void testIterator() {
		List<String> nameList = Arrays.asList("Amy", "Bob", "Cary");
		
		//Java8 之前遍历方式
		for (String name : nameList) {
			// do something for element
			logger.info("The name is: " + name);
		}
		
		/*
		 * Java8 Lambda遍历方式
		 * 优点：代码结构更简洁、紧凑(当只有一行时，方括号可省略)，据说运行效率更高
		 * 
		 * <p>name的参数类型是由编译器推测出来的</p>
		 */
		nameList.forEach(name -> { logger.info("The name is: " + name + "; print by Java8 Lambda"); });
	}
	
	/**
	 * 测试Lambda表达式引用成员变量或局部变量
	 */
	@Test
	public void testUseVariable() {
		List<String> nameList = Arrays.asList("Amy", "Bob", "Cary");
		
		/* 
		 * Lambda表达时可以引用成员变量或是局部变量
		 * 
		 * <p>非final类型的变量会转换为final类型，
		 * 所以Lambda表达式中变量不能改变引用</p>
		 */
		final String headNote = "The name is: ";
		String tailNote = " print by Java8 Lambda! ";
		nameList.forEach(name -> logger.info(headNote + name + tailNote));
	}
	
	/**
	 * 测试Lambda表达式返回值
	 * 
	 * <p>当表达式中只有一行时，可以省略return语句</p>
	 */
	@Test
	public void testReturnValue() {
		List<String> nameList = Arrays.asList("Bob", "Jack", "Amy");
		List<String> jobList = Arrays.asList("Teacher", "Doctor", "Engine");
		
		/*
		 * sort函数返回空值, 而String类的compareTo方法会返回一个int类型值
		 * 
		 * sort方法接收的是一个Comparator参数，而这里传的就是一个Comparator参数
		 * 因为Comparator是一个函数式接口，只有compare方法，而这里(name, anotherName)
		 * 相当于Comparator中的compare(name, anotherName)
		 */
		nameList.sort( (name, anotherName) -> name.compareTo(anotherName) );
		nameList.sort( (name, anotherName) -> {
			//与上一句代码等效
			int result = name.compareTo(anotherName);
			return result;
		});
		
		/*
		 * 不能传入方法引用，因为sort方法接收的是一个Comparator参数
		 * 而不像forEach一样接收Consumer参数
		 */
//		nameList.sort(Comparator::compare);
		nameList.forEach(name -> logger.info("The name is: " + name) );
		
		/*
		 * List的sort方法也是Java8新增的方法，该方法接收一个Comparator参数
		 * 当传入的参数值为null时，则List中元素的类必须实现了Comparable接口(String实现了此接口)
		 */
		jobList.sort(null);
		jobList.forEach(job -> logger.info("The job is: " + job));
	}

}
