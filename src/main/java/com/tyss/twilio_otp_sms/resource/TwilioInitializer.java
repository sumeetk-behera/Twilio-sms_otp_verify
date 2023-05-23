package com.tyss.twilio_otp_sms.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;
import com.tyss.twilio_otp_sms.config.TwilioConfig;

@Configuration
public class TwilioInitializer {

	@SuppressWarnings("unused")
	private TwilioConfig twilioConfig;

	@Autowired
	public TwilioInitializer(TwilioConfig twilioConfig) {

		this.twilioConfig = twilioConfig;

		Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());

		System.err.println("twilio accnt initialized with accntSid: " + twilioConfig.getAccountSid());

	}

}
