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
 * <code>NoRebaseFile.java</code>
 * <pre>
 *     The description...
 * </pre>
 *
 * @author Richard
 * @version 1.0.0
 */
public class NoRebaseFile {
	
	private static final Logger logger = Logger.getLogger(NoRebaseFile.class);
	
	/**
	 * <p>Git No Rebase特性测试分支A</p>
	 */
	public void rebaseTest() {
		logger.info("模拟测试方法");
	}
	
	/**
	 * <p>Git No Rebase方法第二次提交测试</p>
	 */
	public void featureMethod() {
		logger.info("模拟测试分支2第二次提交的方法");
	}

}
