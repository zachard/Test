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

package com.richard.java.git.rebase;

import org.apache.log4j.Logger;

/**
 * <code>AnotherRebaseFile.java</code>
 * <pre>
 *     The description...
 * </pre>
 *
 * @author Richard
 * @version 1.0.0
 */
public class AnotherRebaseFile {
	
	private static final Logger logger = Logger.getLogger(AnotherRebaseFile.class);
	
	/**
	 * <p>用于测试rebase的分支A第一次提交代码</p>
	 */
	public void methodRebase() {
		logger.info("rebase分支A第一次提交代码");
	}
	
	/**
	 * <p>用于测试rebase分支A第二次提交代码</p>
	 * @param times
	 */
	public void methodRebase(int times) {
		logger.info("rebase分支A第二次提交代码");
	}
	
	/**
	 * <p>每次push之前都进行rebase的分支B第一次提交</p>
	 */
	public void methodEachRebase() {
		logger.info("每次push之前都进行rebase分支B第一次提交");
	}
	
	/**
	 * <p>第二次提交</p>
	 * 
	 * @param times
	 */
	public void methodEachRebase(int times) {
		logger.info("第二次提交");
	}

}