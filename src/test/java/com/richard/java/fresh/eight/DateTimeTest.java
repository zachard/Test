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

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java 8 Date/Time 新增API测试
 * 
 * <p></p>
 *
 * @author Richard
 * @version 1.0.0
 */
public class DateTimeTest {

	private static final Logger logger = LoggerFactory.getLogger(DateTimeTest.class);
	
	/**
	 * 测试Clock的API
	 */
	@Test
	public void testClock() {
		final Clock clock = Clock.systemUTC();
		
		logger.info(TimeZone.getDefault().toString());
		logger.info(clock.instant().toString());
		
		//代替System.currentTimeMillis()
		logger.info(clock.millis() + "");
	}
	
	/**
	 * 测试LocalDate与LocalTime的API
	 */
	@Test
	public void testLocateDateAndTime() {
		final Clock clock = Clock.systemUTC();
		final LocalDate date = LocalDate.now();
		final LocalDate dateFromClock = LocalDate.now(clock);
		
		logger.info(date.toString());
		logger.info(dateFromClock.toString());
		
		final LocalTime time = LocalTime.now();
		final LocalTime timeFromClock = LocalTime.now(clock);
		
		logger.info(time.toString());
		logger.info(timeFromClock.toString());
		
		final LocalDateTime dateTime = LocalDateTime.now();
		final LocalDateTime dateTimeFromClock = LocalDateTime.now(clock);
		
		logger.info(dateTime.toString());
		logger.info(dateTimeFromClock.toString());
	}
	
	/**
	 * 测试ZonedDateTime API
	 */
	@Test
	public void testZonedDateTime() {
		final Clock clock = Clock.systemUTC();
		final ZonedDateTime zonedDatetime = ZonedDateTime.now();
		final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now( clock );
		final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now( ZoneId.of( "America/Los_Angeles" ) );
		
		logger.info( zonedDatetime.toString() );
		logger.info( zonedDatetimeFromClock.toString() );
		logger.info( zonedDatetimeFromZone.toString() );
	}
	
	/**
	 * 测试Duration类 API
	 */
	@Test
	public void testDuration() {
		final LocalDateTime from = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
		final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 59, 59 );
		final Duration duration = Duration.between( from, to );
		
		logger.info( "Duration in days: " + duration.toDays() );
		logger.info( "Duration in hours: " + duration.toHours() );
	}

}
