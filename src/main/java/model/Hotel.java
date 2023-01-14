package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nazwa;

    private String opis;

    @CreationTimestamp
    private LocalDateTime dataCzasStart;

    @CreationTimestamp
    private LocalDateTime dataCzasKoniec;

    @ManyToOne
    private Wycieczka wycieczka;

    @ManyToOne
    private Lokalizacja lokalizacja;
}
