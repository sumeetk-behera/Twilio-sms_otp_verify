package com.tyss.twilio_otp_sms.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties("twilio")
@Data
public class TwilioConfig {

	private String accountSid;
	private String authToken;
	private String trialNumber;

}
