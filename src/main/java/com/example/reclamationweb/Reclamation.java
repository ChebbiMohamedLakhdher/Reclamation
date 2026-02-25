package com.example.reclamationweb;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Reclamation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Long userId;          // ID from User Service

    private Long eventId;          // optional, from Event Service
    private Long ticketId;         // optional, from Ticket Service

    @NotBlank
    private String subject;

    @NotBlank
    @Column(length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    private ReclamationStatus status = ReclamationStatus.PENDING;

    @Column(length = 2000)
    private String adminResponse;   // response from admin/organizer

    private LocalDateTime createdAt;
    private LocalDateTime resolvedAt;

    // Automatically set createdAt before persist
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}