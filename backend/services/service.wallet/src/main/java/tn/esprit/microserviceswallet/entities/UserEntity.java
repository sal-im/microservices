package tn.esprit.microserviceswallet.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {
    private Long id;

    private String firstName;

    private String lastName;
    private String cin;
    private String code;


    private String email;
    private String password;
}
