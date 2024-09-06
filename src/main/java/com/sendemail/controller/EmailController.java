package com.sendemail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sendemail.model.EmailRequestDTO;
import com.sendemail.service.EmailService;

@RestController
@RequestMapping("/api/email")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/send")
	public String sendEmail(@RequestBody EmailRequestDTO emailRequest) {
		emailService.sendAndSaveEmail(emailRequest.getToEmail(), emailRequest.getSubject(), emailRequest.getBody());
		return "Email sent and saved successfully to " + emailRequest.getToEmail();
	}
}

/*
 * https:// accounts.google.com/v3/signin/challenge/pwd?TL=
 * AKeb6mxLAQNPXJhJdhWeebrFjqUZNZJSvuCsiRvX_uwRHz-HIBsLsqVvRAOh0uhC&cid=2&
 * continue=https%3A%2F%2Fmyaccount.google.com%2Fapppasswords&flowName=
 * GlifWebSignIn&followup=https%3A%2F%2Fmyaccount.google.com%2Fapppasswords&ifkv
 * =Ab5oB3rwg4VrMjyhOOCZqHno8SqzA1l8g_BoeJmWrKfG2CpJGA_u2iSQxItbveob3PGd8-
 * Wv6fLcCQ&osid=1&rart=
 * ANgoxccNizrSTcUs7_DMO1Mu1mY4KPZ93iREaKO_F8GMYyzEVr_xG7oILTnrr0L0u6IeWfYubQLmp8yrm6ENzzg1XuZmhBld0soIH3kxkr4OpAIKoZ4EwlM
 * &rpbg=1&service=accountsettings
 */