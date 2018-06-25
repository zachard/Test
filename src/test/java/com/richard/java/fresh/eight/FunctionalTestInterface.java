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

/**
 * Java8 函数式接口测试
 * 
 * <p>函数式接口只能包含一个方法</p>
 *
 * @author Richard
 * @version 1.0.0
 */
@FunctionalInterface
public interface FunctionalTestInterface {
	
	/**
	 * 函数式接口只能包含一个方法
	 */
	void method();
	
	/**
	 * 这个方法存在时，会编译不通过
	 */
	//void anotherMethod();
	
	/**
	 * 函数式接口可以含有default修饰的函数
	 * 
	 * <p>这个在接口中的函数包含有方法体</p>
	 */
	default void defaultMethod() {
		
	}
	
	/**
	 * 函数式接口可以含有多个default修饰的有方法体的函数
	 */
	default String anotherMethod() {
		return null;
	}
}
