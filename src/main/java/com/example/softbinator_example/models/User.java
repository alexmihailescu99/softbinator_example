package com.example.softbinator_example.models;

import lombok.*;

import javax.persistence.*;

@Entity                // - model(entitate) (un tabel in DB)
@Table(name = "users") // - numele tabelului in DB
@Getter                // - Lombok - genereaza automat getteri pentru toate field-urile
@Setter                // - Lombok - genereaza automat setteri pentru toate field-urile
@NoArgsConstructor     // - Lombok - genereaza un constructor fara parametri
@AllArgsConstructor    // - Lombok - genereaza un constructor cu toti parametri
@Builder               // - Lombok - ofera functionalitate de builder pattern
// Un model(entity) este un obiect Java care se mappeaza direct in DB
public class User {

    @Id // - Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // - genereaza cu incrementare
    private Long id;

    // Field-urile se vor mappa automat in DB pe field-uri cu acelasi nume
    private String username;

    private String password;

    private String email;

    // Aici, camelCase se transforma in camel_case in db(ex. friendId - friend_id)
    private Long friendId;
}
