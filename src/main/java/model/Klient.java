package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

//@Data -> przed usunięciem wyrzucalo błąd
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Klient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nazwa;

    private int wiek;

    @ManyToMany
    @EqualsAndHashCode.Exclude
    private Set<OfertaWakacyjna> wykupioneOferty;
}
