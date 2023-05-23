package com.tyss.twilio_otp_sms.resource;

import org.springframework.stereotype.Component;

@Component
public class TwilioOtpHandler {

//	@Autowired
//	private TwilioService twilioService;
//
//	public Mono<ServerResponse> sendOTP(ServerRequest serverRequest) {
//
//		// get MONO of RequestDto
//		return serverRequest.bodyToMono(RequestDto.class)
//				.flatMap(dto -> twilioService.sendOTP(dto))
//				.flatMap(dto -> ServerResponse.status(HttpStatus.OK)
//						.body(BodyInserters.fromValue(dto))); //1st way--> here return type is ResponseDto in sendOTP().
//
//	}
//
//	public Mono<ServerResponse> validateOTP(ServerRequest serverRequest) {
//		return serverRequest.bodyToMono(RequestDto.class)
//				.flatMap(dto -> twilioService.validatOTP(dto.getOtp(), dto.getUserName()))
//				.flatMap(dto -> ServerResponse.status(HttpStatus.OK)
//						.bodyValue(dto)); //2nd way--> here return in validateOTP() is string.
//	}
}
