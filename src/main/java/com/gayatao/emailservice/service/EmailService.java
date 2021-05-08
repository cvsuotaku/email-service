package com.gayatao.emailservice.service;

import com.gayatao.emailservice.dto.SendEmailRequestDTO;
import com.gayatao.emailservice.dto.SendEmailResponseDTO;

public interface EmailService {
    public SendEmailResponseDTO sendEmail(SendEmailRequestDTO sendEmailRequestDTO);
}
