package com.sendemail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sendemail.model.EmailRequestDTO;

@Repository
public interface EmailRepository extends JpaRepository<EmailRequestDTO, Long> {
}
