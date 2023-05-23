package com.tyss.twilio_otp_sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.twilio_otp_sms.dto.RequestDto;
import com.tyss.twilio_otp_sms.service.TwilioService;

@RestController
public class SmsController {

	@Autowired
	private TwilioService twilioService;

	@PostMapping("/sendsms")
	public ResponseEntity<Object> sendOTP(@RequestBody RequestDto dto) {

		String sendOTP = twilioService.sendOTP(dto);
		if ("sent".equalsIgnoreCase(sendOTP) || "queued".equalsIgnoreCase(sendOTP)) {
			return new ResponseEntity<>("sent successfully", HttpStatus.OK);
		}
		return new ResponseEntity<>("failed to send", HttpStatus.BAD_REQUEST);

	}
	
	
}
