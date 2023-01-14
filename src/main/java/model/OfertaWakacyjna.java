package model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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

    @CreationTimestamp
    private LocalDateTime dataCzasStart;

    @CreationTimestamp
    private LocalDateTime dataCzasKoniec;

    private double cenaDziecko;

    private double cebaDorosly;

    private int iloscWolnychMiejsc;

    @ManyToMany (mappedBy = "wykupioneOferty")
    private Set<Klient> klienci; //

    @ManyToOne
    private Wycieczka wycieczka;
}
