package com.tyss.twilio_otp_sms.dto;

import lombok.Data;

@Data
public class VerifyRequestDto {

	private String otp;
	private String phoneNumber;

}
