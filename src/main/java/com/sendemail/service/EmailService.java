package com.sendemail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sendemail.model.EmailRequestDTO;
import com.sendemail.repository.EmailRepository;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailRepository emailRepository;

    public void sendAndSaveEmail(String toEmail, String subject, String body) {
        // Send email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("Shubham Meshram <shubhammeshram0099@gmail.com>");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
        System.out.println("Email Sent Successfully to " + toEmail);

        // Save email details to the database
        EmailRequestDTO emailRequestDTO = new EmailRequestDTO(toEmail, subject, body, LocalDateTime.now());
        emailRepository.save(emailRequestDTO);
        System.out.println("Email details saved to the database.");
    }
}
