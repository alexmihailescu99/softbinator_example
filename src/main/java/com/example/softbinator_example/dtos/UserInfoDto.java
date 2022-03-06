package com.example.softbinator_example.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
// Un DTO este o clasa Java normala care mappeaza un obiect din DB pe un obiect de transfer
// Folosim pentru a evita trimiterea de date nefolositoare sau care pot compromite securitatea(ex. parola)
public class UserInfoDto {
    private Long id;

    private String username;

    private String email;

    private Long friendId;
}
