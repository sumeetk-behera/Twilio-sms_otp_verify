package com.tyss.twilio_otp_sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TwilioOtpSmsApplication {

//	@Autowired
//	private TwilioConfig twilioConfig;

//	@PostConstruct
//	public void initTwilio() {
//		Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
//	}

	public static void main(String[] args) {
		SpringApplication.run(TwilioOtpSmsApplication.class, args);
	}

}
