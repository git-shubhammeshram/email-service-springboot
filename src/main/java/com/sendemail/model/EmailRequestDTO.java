package com.sendemail.model;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "emails")
@Data
@NoArgsConstructor
@Getter
@Setter
public class EmailRequestDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "to_email")
    private String toEmail;

    @Column(name = "subject")
    private String subject;

    @Column(name = "body")
    private String body;

    @Column(name = "sent_at")
    private LocalDateTime sentAt;
    
    

	public EmailRequestDTO(String toEmail, String subject, String body, LocalDateTime sentAt) {
		super();
		this.toEmail = toEmail;
		this.subject = subject;
		this.body = body;
		this.sentAt = sentAt;
	}
    
    
    
    


}
