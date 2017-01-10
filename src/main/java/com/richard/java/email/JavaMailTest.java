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

package com.richard.java.email;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * The description...
 * <p></p>
 *
 * @author Richard
 * @version 1.0.0
 */
public class JavaMailTest {
	
	public static String account = "xxxxxx@126.com";
	public static String passwd = "xxxxxxxxx";
	
	public static String emailHost = "smtp.126.com";
	public static String receiveMailAccount = "xxxxx@qq.com";
	
	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", emailHost);
		props.setProperty("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(props);
		session.setDebug(true);
		
		MimeMessage message = createMimeMessage(session, account, receiveMailAccount);
		
		Transport transport = session.getTransport();
		transport.connect(account, passwd);
		
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}
	
	/**
	 * 创建一个邮件信息
	 * 
	 * @param session      与服务器的会话
	 * @param sendMail     发件人
	 * @param receiveMail  收件人
	 * @return             邮件
	 * @throws Exception
	 */
	private static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
		MimeMessage message = new MimeMessage(session);
		
		message.setFrom(new InternetAddress(sendMail, "richard", "UTF-8"));
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "zengzp", "UTF-8"));
		message.setSubject("测试邮件的主题", "UTF-8");
		message.setContent("测试邮件的正文", "text/html;charset=UTF-8");
		message.setSentDate(new Date());
		message.saveChanges();
		
		return message;
	}

}
