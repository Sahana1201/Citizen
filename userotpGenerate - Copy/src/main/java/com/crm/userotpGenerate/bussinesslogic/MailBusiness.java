package com.crm.userotpGenerate.bussinesslogic;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailBusiness {

	String mailid;
	String mailOtpBussinesslass;

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public String getMailOtpBussinesslass() {
		return mailOtpBussinesslass;
	}

	public void setMailOtpBussinesslass(String mailOtpBussinesslass) {
		this.mailOtpBussinesslass = mailOtpBussinesslass;
	}

	public MailBusiness(String mailid) {
		super();
		this.mailid = mailid;

	}

	public MailBusiness() {
		// TODO Auto-generated constructor stub
	}

	public String mailOtp(String otp) {
		OtpBusiness mail = new OtpBusiness();

		String to = "sahanasandy1208@gmail.com";
		String from = "sahanasandy1205@gmail.com";

		String host = "smtp.gmail.com";

		Properties properties = System.getProperties();

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(from, "Sahanamurthy@123");

			}

		});

		try {

			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			message.setSubject("Generated OTP Received");

			message.setText(otp);

			Transport.send(message);

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
		return mail.generateOTP(4);

	}

}
