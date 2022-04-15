package com.dar.repository;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = true, unique = true, length = 50)
    String clientId;

    @Column(nullable = true, length = 50)
    String fullName;

    @Column(nullable = true, length = 50)
    String email;
}
