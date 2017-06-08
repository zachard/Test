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

package com.richard.java.learn.quartz;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * <code>HelloJob.java</code>
 * <pre>
 *     Quartz Job演示类
 * </pre>
 *
 * @author Richard
 * @version 1.0.0
 */
public class HelloJob implements Job {
	
	/**
	 * 日志记录器
	 */
	private static final Logger logger = Logger.getLogger(HelloJob.class);
	
	/**
	 * Job属性
	 */
	String jobSays;
	
	/**
	 * 默认构造器
	 * <p>默认构造器在Job实现类中必须存在</p>
	 */
	public HelloJob() {
		setJobSays("Test");
	}

	/**
	 * 实现任务的方法
	 * @param context
	 * @throws JobExecutionException
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap jobDataMap = context.getMergedJobDataMap();
		String jobSays = jobDataMap.getString("jobSays");
		String anotherJobSays = this.jobSays;
		logger.info("打印值" + jobSays + "; setter方法设置的值: " + anotherJobSays);
	}

	/**
	 * jobSays属性设置
	 * 
	 * @param jobSays   需要设置的值
	 */
	public void setJobSays(String jobSays) {
		this.jobSays = jobSays;
	}

}
