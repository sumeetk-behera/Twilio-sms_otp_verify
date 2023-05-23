package com.tyss.twilio_otp_sms.service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.tyss.twilio_otp_sms.config.TwilioConfig;
import com.tyss.twilio_otp_sms.dto.RequestDto;

@Service
public class TwilioService {

//	ResponseDto responseDto;

	String no;

	Map<String, String> otpMap = new HashMap<>();

	String otp;

	private TwilioConfig twilioConfig;

	@Autowired
	public TwilioService(TwilioConfig twilioConfig) {
		this.twilioConfig = twilioConfig;
	}

//	

	public String sendOTP(@RequestBody RequestDto requestDto) {
		no = requestDto.getPhoneNumber();
		PhoneNumber to = new PhoneNumber(requestDto.getPhoneNumber());
		PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
		otp = generateOTP(no);
		System.err.println("generated otp " + otp);
		String otpMessage = "Your OTP is :-" + otp + " use this otp for verification";
		Message sms = Message.creator(to, from, otpMessage).create();
		return sms.getStatus().toString();
	}

//			otpMap.put(requestDto.getUserName(), otp);

//			 responseDto = new ResponseDto(OtpStatus.DELIVERED, otpMessage);

//		} catch (Exception e) {
//			responseDto = new ResponseDto(OtpStatus.FAILED, e.getMessage());
//		}
//		return Mono.just(responseDto);

	// 6 digit OTP

	@Cacheable(value = "verify_cache")
	private String generateOTP(String no) {
		String format = new DecimalFormat("000000").format(new Random().nextInt(999999));
		otpMap.put(no, format);
		System.err.println(otpMap + " otp map");
		return format;
	}

	public String getOTP(String phoneNumber) {
		this.no = phoneNumber;
		System.err.println(phoneNumber); 
		String otpValue = otpMap.get(no);
		System.err.println(otpValue + " otp value in verify");
		return otpValue;

	}

//	// VALIDATE OTP
//	public Mono<String> validatOTP(String userInputOtp, String userName) {
//		if (userInputOtp.equals(otpMap.get(userName))) {
//
//			otpMap.remove(userName, userInputOtp);
//
//			return Mono.just("Valid OTP, please proceed");
//
//		} else {
//			return Mono.error(new IllegalArgumentException("Invalid OTP, please retry"));
//		}
//
//	}

}
