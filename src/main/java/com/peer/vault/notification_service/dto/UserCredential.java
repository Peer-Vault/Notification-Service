package com.peer.vault.notification_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCredential {

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private String gender;

    private String email;

    private String phoneNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateOfBirth;

    private String address;

    private LocalDateTime accountCreatedAt;

    private String profilePictureUrl;

    private String bio;




}
