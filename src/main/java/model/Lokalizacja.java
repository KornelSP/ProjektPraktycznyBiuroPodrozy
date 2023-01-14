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
    private Set<Atrakcja> atrakcje;

    @OneToMany (mappedBy = "lokalizacja")
    private Set <Hotel> hotele;
}
