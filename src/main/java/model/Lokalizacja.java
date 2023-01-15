package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lokalizacja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lokalizacja;

    @OneToMany (mappedBy = "lokalizacja")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Atrakcja> atrakcje;

    @OneToMany (mappedBy = "lokalizacja")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set <Hotel> hotele;
}
