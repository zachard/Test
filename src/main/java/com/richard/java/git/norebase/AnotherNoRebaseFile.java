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
 * <code>AnotherNoRebaseFile.java</code>
 * <pre>
 *     The description...
 * </pre>
 *
 * @author Richard
 * @version 1.0.0
 */
public class AnotherNoRebaseFile {
	
	private static Logger logger = Logger.getLogger(AnotherNoRebaseFile.class);
	
	/**
	 * <p>Git No Rebase 测试分支 b</p>
	 */
	public void noRebaseTest() {
		logger.info("Git No Rebase Method ");
	}
	
	/**
	 * <p>测试分支b第二次提交的方法</p>
	 */
	public void featureMethod() {
		logger.info("测试分支b第二次提交的测试代码");
	}
	
	/**
	 * <p>测试分支b中第三次提交的方法</p>
	 * @param times
	 */
	public void featureMethod(int times) {
		logger.info("这是分支中的第" + times + "方法" + "测试reset文件的修改");
	}

}
