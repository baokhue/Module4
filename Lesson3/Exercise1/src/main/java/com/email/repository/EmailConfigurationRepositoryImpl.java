package com.email.repository;

import com.email.model.EmailConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EmailConfigurationRepositoryImpl implements IEmailConfigurationRepository{
    static Map<Integer, EmailConfiguration> list;

    static {
        list = new HashMap<>();
        list.put(1, new EmailConfiguration(1,"English", 5, false, "Monkey.D"));
        list.put(2, new EmailConfiguration(2,"Vietnamese", 10, true, "Nami"));
        list.put(3, new EmailConfiguration(3,"Japanese", 15, true, "Zoronoa"));
        list.put(4, new EmailConfiguration(4,"Chinese", 25, false, "Reighley"));
        list.put(5, new EmailConfiguration(5,"Vietnamese", 50, false, "Jimbei"));
        list.put(6, new EmailConfiguration(6,"English", 100, true, "Brook"));
    }


    @Override
    public List<EmailConfiguration> display() {
        return new ArrayList<>(list.values());
    }

    @Override
    public void update(EmailConfiguration emailConfiguration) throws Exception {
        if (list.containsKey(emailConfiguration.getId())) {
            list.put(emailConfiguration.getId(), emailConfiguration);
            return;
        }
        throw new Exception("Product's ID does not exist");
    }

    @Override
    public EmailConfiguration findById(int id) {
        return list.get(id);
    }
}
