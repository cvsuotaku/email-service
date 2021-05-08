package com.gayatao.emailservice.controller;

import com.gayatao.emailservice.dto.SendEmailRequestDTO;
import com.gayatao.emailservice.service.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("email")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public void sendEmail(@RequestBody @Valid SendEmailRequestDTO sendEmailRequestDTO) {
        emailService.sendEmail(sendEmailRequestDTO);
    }

}
