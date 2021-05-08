package com.gayatao.emailservice.service;

import com.gayatao.emailservice.dto.SendEmailRequestDTO;
import com.gayatao.emailservice.dto.SendEmailResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender emailSender;

    @Override
    public SendEmailResponseDTO sendEmail(SendEmailRequestDTO sendEmailRequestDTO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sendEmailRequestDTO.getEmail());
        message.setTo("alquinngayatao@gmail.com");
        message.setSubject("PORTFOLIO");
        message.setText(sendEmailRequestDTO.getName() + sendEmailRequestDTO.getMessage());
        emailSender.send(message);
        log.info("Email sent from " + sendEmailRequestDTO.getEmail());

        return SendEmailResponseDTO.builder()
                .code(HttpStatus.OK.getReasonPhrase())
                .message("Email sent.")
                .build();
    }
}
