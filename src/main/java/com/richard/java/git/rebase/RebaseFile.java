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
 * <code>RebaseFile.java</code>
 * <pre>
 *     The description...
 * </pre>
 *
 * @author Richard
 * @version 1.0.0
 */
public class RebaseFile {
	
	private static final Logger logger = Logger.getLogger(RebaseFile.class);
	
	/**
	 * <p>测试rebase分支b第一次提交的代码</p>
	 */
	public void rebaseMethod() {
		logger.info("测试rebase第一次提交的代码");
	}
	
	/**
	 * <p>测试rebase第二次提交代码的方法</p>
	 * 
	 * @param time   提交次数
	 */
	public void rebaseMethod(int time) {
		logger.info("测试rebase第二次提交的代码");
	}
	
	/**
	 * <p>测试rebase分支b第三次提交</p>
	 * 
	 * @param time    提交次数
	 */
	public void rebaseMethod(String time) {
		logger.info("测试rebase分支B第三次提交");
	}
	
	/**
	 * <p>每次push之前都rebase测试分支A第一次提交</p>
	 */
	public void rebaseEachPush() {
		logger.info("每次push之前都rebase分支A第一次提交");
	}
	
	/**
	 * <p>第二次提交</p>
	 * 
	 * @param times
	 */
	public void rebaseEachPush(int times) {
		logger.info("第二次提交");
		logger.info("先执行合并，然后再撤销操作，执行变基");
		logger.info("rebase分支第一次rebase之前的develop分支提交");
		logger.info("测试rebase分支的第一次提交");
		logger.info("测试rebase分支的第二次提交");
		logger.info("rebase分支第二次rebase之前的develop分支提交");
		logger.info("测试rebase分支的第三次提交");
		logger.info("测试rebase分支的第四次提交");
	}

}
