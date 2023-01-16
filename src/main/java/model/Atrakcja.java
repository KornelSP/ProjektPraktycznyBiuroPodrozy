package model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Atrakcja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nazwa;

    private String opis;

    private int standard; //ilość gwiazdek

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Wycieczka wycieczka;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Lokalizacja lokalizacja;

}
