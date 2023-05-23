package com.tyss.twilio_otp_sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.twilio_otp_sms.dto.VerifyRequestDto;
import com.tyss.twilio_otp_sms.service.TwilioService;

@RestController
public class VerifyController {

	@Autowired
	private TwilioService twilioService;

	@PostMapping("/verify")
	public String verifyOTP(@RequestBody VerifyRequestDto dto) {
		System.err.println("inside verify otp");

		System.err.println(dto.getOtp() + " user entered otp");

		System.err.println(dto.getPhoneNumber() + "user no.");

		String serviceOtp = twilioService.getOTP(dto.getPhoneNumber());

		if (dto.getOtp().equals(serviceOtp)) {
//			otpService.clearOTP(dto.getPhoneNo());
			return "Correct OTP";
		} else
			System.err.println("verify else statement");
		return "Incorrect OTP";
	}
}
