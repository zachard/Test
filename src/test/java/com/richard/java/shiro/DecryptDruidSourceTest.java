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

package com.richard.java.shiro;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 解码配置文件
 * <p></p>
 *
 * @author Richard
 * @version 1.0.0
 */
public class DecryptDruidSourceTest {
	
	private static DecryptDruidSource source = null;
	
	@BeforeClass
	public static void init() {
		source = new DecryptDruidSource();
	}

	@Test
	public void test() {
		source.setUsername("f0PSl0Lzxh6CxzuFIdEg+wVx045fSE2VtUP45G9HH2cjVQnmGGgcK5CLzNUJoR6tGwRO44h74OxrBWuDzWC8jg==");
	}

}
