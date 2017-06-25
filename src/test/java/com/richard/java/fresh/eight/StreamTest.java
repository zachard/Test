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

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java 8 新增类 Stream 测试
 * <p></p>
 *
 * @author Richard
 * @version 1.0.0
 */
@SuppressWarnings("all")
public class StreamTest {
	
	private static final Logger logger = LoggerFactory.getLogger(StreamTest.class);
	
	/**
	 * 状态枚举
	 * 
	 * @author richard
	 */
	private enum Status {
		OPEN, CLOSED;
	}
	
	/**
	 * 任务类
	 * 
	 * @author richard
	 */
	private static final class Task {
		private final Status status;
		private final Integer points;
		
		Task(final Status status, final Integer points) {
			this.status = status;
			this.points = points;
		}

		public Status getStatus() {
			return status;
		}

		public Integer getPoints() {
			return points;
		}
		
		@Override
		public String toString() {
			return String.format("[%s, %d]", status, points);
		}
	}

	/**
	 * 测试利用Stream类进行过滤
	 */
	@Test
	public void testStream() {
		final Collection<Task> tasks = Arrays.asList(
				new Task(Status.OPEN, 5), 
				new Task(Status.OPEN, 13), 
				new Task(Status.CLOSED, 8));
		
		/*
		 * Collection的stream方法将集合转换为一个Stream类型，便于进行集合处理
		 * Stream的filter方法将满足断言的元素提取出来并组成新的Stream
		 * Stream的mapToInt方法对Stream进行处理，并且将得到的值转换为一个IntStream
		 * IntStream的sum方法用于对IntStream集合进行求和操作
		 */
		final int totalPointOfOpenTasks = tasks
				.stream()
				.filter(task -> task.getStatus() == Status.OPEN)
				.mapToInt( Task::getPoints )
				.sum();
		logger.info("Open Task Points is: " + totalPointOfOpenTasks);
		
		/*
		 * Stream的parallel的方法将Stream转换为可并行的Stream，有可能返回自己
		 */
		final double totalPoints = tasks
				.stream()
				.parallel()
				.map( task -> task.getPoints() )
				.reduce(0,  Integer::sum);
		logger.info("Total Points is: " + totalPoints);
		
		/*
		 * 对集合进行分组
		 * 
		 * collect方法
		 */
		final Map<Status, List<Task>> map = (Map) tasks
				.stream()
				.collect( Collectors.groupingBy(Task::getStatus) );
		logger.info(map.toString());
	}

}
