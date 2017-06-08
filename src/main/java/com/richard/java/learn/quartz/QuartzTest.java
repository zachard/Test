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

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * <code>QuartzTest.java</code>
 * 
 * <pre>
 * 测试Quartz示例结果
 * </pre>
 *
 * @author Richard
 * @version 1.0.0
 */
public class QuartzTest {

	public QuartzTest() {
	}

	public static void main(String[] args) {

		try {
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

			// Trigger the job to run now, and then every 40 seconds
			Trigger trigger = newTrigger()
					.withIdentity("myTrigger", "group1")
					.usingJobData("jobSays", "Not Hello World!")
					.startNow()
					.withSchedule(simpleSchedule()
							.withIntervalInSeconds(40)
							.repeatForever())
					.build();
						
			// define the job and tie it to our HelloJob class
			JobDetail job = newJob(HelloJob.class)
					.withIdentity("myJob", "group1")
					.usingJobData("jobSays", "Hello World")
					.usingJobData("myFloatValue", 3.141f)
					.build();

			// Tell quartz to schedule the job using our trigger
			scheduler.scheduleJob(job, trigger);
			scheduler.start();

			try {
				Thread.sleep(6000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			
			scheduler.shutdown();
		} catch (SchedulerException se) {
			se.printStackTrace();
		}
	}

}
