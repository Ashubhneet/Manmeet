package com.demo.project.dto;

import jakarta.persistence.Column;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;

public class CustomerDto {
        private Long id;

        private String firstName;

        private String lastName;
        @NotEmpty(message = "Email should not be empty")
        @Email(message = "valid email is required")
        private String email;

        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,15}$",
                message = "password must be min 8 and max 15 length containing atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
        private String password;

        @jakarta.validation.constraints.Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,15}$",
                message = "password must be min 8 and max 15 length containing atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
        private String confirmPassword;
      //  @Size(min=10,max = 10,message =@Pattern(regexp="(^$|[0-9]{10})")  "minimum 10 length requires")
     //   @Range(min=9,max=11,message ="10 digits are required")
    @NotNull
    @Size(min = 10,max = 10)
        private String phonenumber;

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

        public String getPhonenumber() {
                return phonenumber;
        }

        public void setPhonenumber(String phonenumber) {
                this.phonenumber = phonenumber;
        }
}

