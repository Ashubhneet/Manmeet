package com.demo.project.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
public class CustomerDto {
        private Long id;
        @NotEmpty
        private String firstName;
        @NotEmpty
        private String lastName;
        @NotEmpty(message = "Email should not be empty")
        @Email
        private String email;
        @NotEmpty(message = "Password should not be empty")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,15}$",
                message = "password must be min 8 and max 15 length containing atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
        private String password;
        @NotEmpty(message = "Password should not be empty")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,15}$",
                message = "password must be min 8 and max 15 length containing atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
        private String confirmPassword;
        @Size(min=10,max = 10,message = "minimum 10 length requires")
        private long phonenumber;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
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

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getConfirmPassword() {
                return confirmPassword;
        }

        public void setConfirmPassword(String confirmPassword) {
                this.confirmPassword = confirmPassword;
        }

        public long getPhonenumber() {
                return phonenumber;
        }

        public void setPhonenumber(long phonenumber) {
                this.phonenumber = phonenumber;
        }
}

