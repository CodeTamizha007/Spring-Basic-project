package com.sd.sdshop.apis.customers;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CustomersRequestDTO {

    @NotBlank(message = "userName is required")
    @Size(min = 6, max = 8, message = "userName must be 3 to 50 characters")
    private String userName;

    @NotBlank(message = "password is required")
    @Size(min = 8, max = 12, message = "password must be at least 8 characters")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).+$",
            message = "password must contain upper, lower, digit and symbol"
    )
    private String password;

    @Email(message = "mailId must be a valid email")
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$",
            message = "mailId must be a gmail.com address"
    )
    private String mailId;

    @Pattern(regexp = "^[0-9]{10}$", message = "phoneNo must be exactly 10 digits")
    private String phoneNo;

    public CustomersRequestDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
