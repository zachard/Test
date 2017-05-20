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

package com.richard.java.git.norebase;

import org.apache.log4j.Logger;

/**
 * <code>DevelopTest.java</code>
 * <pre>
 *     The description...
 * </pre>
 *
 * @author Richard
 * @version 1.0.0
 */
public class DevelopTest {
	
	private static final Logger logger = Logger.getLogger(DevelopTest.class);
	
	/**
	 * <P>测试rebase之前的develop分支提交</p>
	 */
	public void methodBrforeRebase() {
		logger.info("测试rebase之前的一次提交");
	}

}