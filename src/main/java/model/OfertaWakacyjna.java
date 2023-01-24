package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfertaWakacyjna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private LocalDateTime dataCzasStart;

//    private LocalDateTime dataCzasKoniec;

    private double cenaDziecko;

    private double cenaDorosly;

    private int iloscMiejsc;

    @ManyToMany (mappedBy = "wykupioneOferty")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Klient> klienci; //

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Wycieczka wycieczka;
}
