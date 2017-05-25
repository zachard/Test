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

package com.richard.java.file.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 测试Reader读取CVS文件
 * <p></p>
 *
 * @author Richard
 * @version 1.0.0
 */
public class FileUtilTest {
	
	private static final Logger logger = Logger.getLogger(FileUtilTest.class);

	/**
	 * 测试读取CVS文件
	 */
	@Test
	public void testReadCSVFile() {
		String path = this.getClass().getResource("/keywords.csv").getPath();
		File file = new File(path);
		String str = "";
		BufferedReader reader = null;
		try {
			InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file), "GB2312");
			reader = new BufferedReader(inputReader);
			while ((str = reader.readLine()) != null) {
			        logger.info("求冲突");
                    logger.info(str);
                    logger.info("紧急修改之后");
			}
		} catch (FileNotFoundException nfe) {
			logger.error("文件不存在");
		} catch (IOException ioe) {
			logger.error("读取文件出错");
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
