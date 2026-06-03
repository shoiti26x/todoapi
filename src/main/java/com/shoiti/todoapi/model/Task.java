package com.shoiti.todoapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
 @Table(name = "tasks")
 @Data
 @NoArgsConstructor
 @AllArgsConstructor

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Titulo é obrigatorio")
     private String title;

    private String description;

    private boolean completed = false;

    @CreationTimestamp
     private LocalDateTime createdAt;
}
