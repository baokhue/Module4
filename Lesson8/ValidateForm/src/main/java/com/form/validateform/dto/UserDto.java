package com.form.validateform.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    private int id;

//    @NotEmpty(message = "This field is not allowed to be empty!")
//    @Size(min = 5, max = 45, message = "This field is not valid!")
    private String firstName;

//    @NotEmpty(message = "This field is not allowed to be empty!")
//    @Size(min = 5, max = 45, message = "This field is not valid!")
    private String lastName;

    private String phoneNumber;

    @Min(18)
    private int age;

    @Email(message = "Email is not valid", regexp = "^[\\w.]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+){1,2}$")
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        //first name
        if (userDto.getFirstName().isEmpty()){
            errors.rejectValue("firstName",null,"This field is not allowed to be empty!");
        }else if (userDto.getFirstName().length() < 5 || userDto.getFirstName().length() > 45){
            errors.rejectValue("firstName",null,"This field is not valid!");
        }
        //last name
        if (userDto.getLastName().isEmpty()){
            errors.rejectValue("lastName",null,"This field is not allowed to be empty!");
        }else if (userDto.getLastName().length() < 5 && userDto.getLastName().length() > 45){
            errors.rejectValue("lastName",null,"This field is not valid!");
        }
        //phone number
        if (userDto.getPhoneNumber().isEmpty()){
            errors.rejectValue("phoneNumber",null,"This field is not allowed to be empty!");
        }else if (!userDto.getPhoneNumber().matches("^(09|03|05|02\\(84\\)\\+9|\\(84\\)\\+3|\\(84\\)\\+5|\\(84\\)\\+2)[\\d]{8}$")){
            errors.rejectValue("phoneNumber",null,"Phone number is not valid!");
        }
    }
}
