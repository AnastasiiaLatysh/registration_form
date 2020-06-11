package org.kpi.iasa.model;

import org.kpi.iasa.utils.RegExContainer;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

    @NotBlank(message = "First Name is mandatory")
    @Size(message = "Length of First Name should be in range from 2 to 20", min = 2, max = 20)
    @Pattern(regexp = RegExContainer.REGEX_NAME_LAT,
            message = "First name should be in format [A-Z][a-z]{1,20}")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    @Size(message = "Length of Last Name should be in range from 2 to 20", min = 2, max = 20)
    @Pattern(regexp = RegExContainer.REGEX_NAME_LAT,
            message = "Last name should be in format [A-Z][a-z]{1,20}")
    private String lastName;

    @Pattern(regexp = RegExContainer.REGEX_DATE, message = "Birthday should be in format dd.mm.yyyy")
    private String birthday;

    @Email(message="Email should be valid")
    @NotBlank(message="Email is mandatory")
    private String email;

    @Size(message = "Phone number should not be more than 20 numbers", max = 20)
    private String phoneNumber;

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
