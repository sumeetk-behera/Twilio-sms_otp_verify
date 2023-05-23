package com.tyss.twilio_otp_sms.service;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Service
public class OtpService {

	@Autowired
	private static final Integer EXPIRE_MINS = 5;

	private LoadingCache<String, String> otpCache;

	public OtpService() {
		super();
		otpCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
				.build(new CacheLoader<String, String>() {
					public String load(String key) {
						return null;
					}
				});
	}

	public String generateOTP(String key) {
		String otp = new DecimalFormat("000000").format(new Random().nextInt(999999));
		otpCache.put(key, otp);
		return otp;
	}

	public String getOtp(String key) {
		try {
			return otpCache.get(key);
		} catch (Exception e) {
			return null;
		}
	}

	public void clearOTP(String key) {
		otpCache.invalidate(key);
	}
}
