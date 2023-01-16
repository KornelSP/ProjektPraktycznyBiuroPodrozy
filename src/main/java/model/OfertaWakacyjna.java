package model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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

    private LocalDateTime dataCzasStart;

    private LocalDateTime dataCzasKoniec;

    private double cenaDziecko;

    private double cebaDorosly;

    private int iloscWolnych;

    @ManyToMany (mappedBy = "wykupioneOferty")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Klient> klienci; //

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Wycieczka wycieczka;
}
