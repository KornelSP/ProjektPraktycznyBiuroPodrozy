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
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set <OfertaWakacyjna> oferty;

    @OneToMany (mappedBy = "wycieczka")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set <Atrakcja> atrakcja;

    @OneToMany (mappedBy = "wycieczka")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set <Hotel> Hotele;


}
