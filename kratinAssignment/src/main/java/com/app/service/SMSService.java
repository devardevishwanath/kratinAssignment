package com.app.service;

import com.messagebird.MessageBirdClient;
import com.messagebird.MessageBirdService;
import com.messagebird.MessageBirdServiceImpl;
import com.messagebird.exceptions.MessageBirdException;
import com.messagebird.objects.Message;

public class SMSService {

	private static final String ACCESS_KEY = "uKe8ewTSELI0CsDi4FoEIvo8sMurc0H2kFdv";
	private static final String ORIGINATOR = "MY-APP";

	public void sendNotification(String phoneNumber, String message) throws MessageBirdException {
		MessageBirdService messageBirdService = new MessageBirdServiceImpl(ACCESS_KEY);
		MessageBirdClient messageBirdClient = new MessageBirdClient(messageBirdService);

		Message smsMessage = new Message(message, phoneNumber, ORIGINATOR);
		smsMessage.setReference("YOUR_REFERENCE_ID"); // Set a reference ID if needed

		messageBirdClient.sendMessage(smsMessage);
	}
}
