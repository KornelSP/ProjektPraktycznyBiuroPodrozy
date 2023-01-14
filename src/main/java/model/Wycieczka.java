package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wycieczka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nazwa;

    private String opis;

    @OneToMany (mappedBy = "wycieczka")
    private Set <OfertaWakacyjna> oferty;

    @OneToMany (mappedBy = "wycieczka")
    private Set <Atrakcja> atrakcja;

    @OneToMany (mappedBy = "wycieczka")
    private Set <Hotel> Hotele;


}
