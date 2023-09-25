package com.example.hospitalmanagement.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required. ❗")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required. ❗")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @NotBlank(message = "Phone number is required. \uD83D\uDCDE\uD83D\uDFE2")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number should be a 10-digit number")
    private String phoneNumber;

    @NotBlank(message = "Address is required. \uD83C\uDFE0")
    @Size(max = 255, message = "Address must not exceed 255 characters")
    private String address;

    @NotBlank(message = "City is required. \uD83C\uDFD9\uFE0F")
    private String city;

    @NotBlank(message = "State is required. \uD83D\uDDFD")
    private String state;

    @Pattern(regexp = "\\d{6}", message = "Zip code should be a 6-digit number.\uD83D\uDD22")
    private String zipCode;
}
