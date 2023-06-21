package com.email.service;

import com.email.model.EmailConfiguration;
import com.email.repository.EmailConfigurationRepositoryImpl;
import com.email.repository.IEmailConfigurationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailConfigurationServiceImpl implements IEmailConfigurationService{
    private IEmailConfigurationRepository iEmailConfigurationRepository = new EmailConfigurationRepositoryImpl();

    @Override
    public List<EmailConfiguration> display() {
        return iEmailConfigurationRepository.display();
    }

    @Override
    public void update(EmailConfiguration emailConfiguration) throws Exception {
        iEmailConfigurationRepository.update(emailConfiguration);
    }

    @Override
    public EmailConfiguration findById(int id) {
        return iEmailConfigurationRepository.findById(id);
    }
}
