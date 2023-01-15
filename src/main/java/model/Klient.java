package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
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
    private Set<OfertaWakacyjna> wykupioneOferty; //
}
