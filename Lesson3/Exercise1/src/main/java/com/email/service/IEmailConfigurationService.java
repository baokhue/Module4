package com.email.service;

import com.email.model.EmailConfiguration;

import java.util.List;

public interface IEmailConfigurationService {
    List<EmailConfiguration> display();
    void update(EmailConfiguration emailConfiguration) throws Exception;
    EmailConfiguration findById(int id);
}
