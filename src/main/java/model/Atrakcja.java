package model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

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

    @CreationTimestamp
    private LocalDateTime dataCzasStart;

    @CreationTimestamp
    private LocalDateTime dataCzasKoniec;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Wycieczka wycieczka;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Lokalizacja lokalizacja;

}
