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

package com.richard.java.test.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Test {
	
	public static void main(String[] args) {
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Python", "Lisp");
		
		filter(languages, (str) -> str.startsWith("J"));
		filter(languages, (str) -> str.endsWith("a"));
		filter(languages, (str) -> true);
		filter(languages, (str) -> false);
		filter(languages, (str) -> str.length() > 4);
		
	}
	
	public static void filter(List<String> names, Predicate<String> condition) {
	    names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
	        System.out.println(name + " ");
	    });
	}
}
