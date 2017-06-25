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
import java.util.function.Supplier;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java 8 新特性方法引用测试类
 * 
 * <p></p>
 *
 * @author Richard
 * @version 1.0.0
 */
@SuppressWarnings("all")
public class MethodReferenceTest {
	
	public static class Car {
		
		private static final Logger logger = LoggerFactory.getLogger(Car.class);
		private String name;
		
		/**
		 * 默认构造函数
		 */
		public Car() {
			logger.info("instance a car");
		}
		
		/**
		 * 带名称的构造器
		 * @param name
		 */
		public Car(String name) {
			this.name = name;
		}
		
		/**
		 * 创建一个Car的实例
		 * <p>测试方法引用的构造器引用</p>
		 * 
		 * @param supplier
		 * @return         Car实例
		 */
		public static Car instance(final Supplier<Car> supplier) {
			return supplier.get();
		}
		
		/**
		 * 测试方法引用的静态引用
		 * 
		 * @param carName   Car的名称
		 */
		public static void collide(String carName) {
			logger.info("Collide: " + carName.toString());
		}
		
		/**
		 * 测试方法引用的静态引用
		 * 
		 * @param car      Car实例
		 */
		public static void collide(Car car) {
			logger.info("Collide: " + car.toString());
		}
		
		/**
		 * 测试方法引用的特定对象的方法引用
		 * 
		 * @param another   Car实例
		 */
		public void follow(final Car another) {
			logger.info("Follow: " + another.toString());
		}
		
		/**
		 * 测试方法引用的特定类的任意对象引用
		 */
		public void repair() {
			logger.info("Repaired: " + this.toString());
		}
	}

	/**
	 * 测试构造器方法引用
	 */
	@Test
	public void testConstructorRef() {
		final Car car = Car.instance(Car::new);
	}
	
	/**
	 * 测试静态方法引用
	 */
	@Test
	public void testStaticMethodRef() {
		List<Car> cars = Arrays.asList(new Car("兰博基尼"), new Car("宝马"), new Car("奥迪"));
		List<String> carNames = Arrays.asList("兰博基尼", "宝马", "奥迪");
		
		/*
		 * Collection中的forEach也是Java 8中新增的方法
		 * 它接收一个Consumer类型的参数
		 * Consumer是一个函数式接口吗，做参数可以是Lambda表达式或是方法引用
		 */
		carNames.forEach(Car::collide);
		cars.forEach(Car::collide);
	}
	
	/**
	 * 测试特定类的任意对象的方法引用
	 */
	@Test
	public void testArbitrarilyObjectRef() {
		List<Car> cars = Arrays.asList(new Car("兰博基尼"), new Car("宝马"), new Car("奥迪"));
		
		/*
		 * repair方法不是静态方法，它需要一个类对象来调用
		 * forEach应该是首先判断到repair需要一个类对象来调用
		 * 所以遍历出来的对象会作为调用repair方法的对象
		 * 假设多一个参数，则缺少参数，无法进行处理
		 */
		cars.forEach(Car::repair);
	}
	
	/**
	 * 测试特定对象的方法引用
	 */
	@Test
	public void testInstanceRef() {
		List<Car> cars = Arrays.asList(new Car("兰博基尼"), new Car("宝马"), new Car("奥迪"));
		Car car = Car.instance(Car::new);
		
		cars.forEach(car::follow);
	}	

}
