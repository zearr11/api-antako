package com.anime.antako.entities.db.models.catalog;

import com.anime.antako.entities.db.enums.Country;
import com.anime.antako.entities.db.enums.EmisionDay;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "country_times")
public class CountryTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Country country;

    @Column(nullable = false)
    private LocalTime broadcastTime;

    @Column(nullable = false)
    private EmisionDay emisionDay;

    @ManyToOne
    @JoinColumn(nullable = false, name = "fk_id_anime")
    private Anime anime;

}
