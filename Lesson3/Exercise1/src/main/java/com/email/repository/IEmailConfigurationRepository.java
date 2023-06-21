package com.email.repository;

import com.email.model.EmailConfiguration;

import java.util.List;

public interface IEmailConfigurationRepository {
    List<EmailConfiguration> display();
    void update(EmailConfiguration emailConfiguration) throws Exception;
    EmailConfiguration findById(int id);
}
