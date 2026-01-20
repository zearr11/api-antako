package com.anime.antako.models.group;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Seasonal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, columnDefinition = "TEXT")
    private String seasonal;

    @ManyToOne
    @JoinColumn(nullable = false, name = "fk_id_year")
    private Year year;

    @ManyToOne
    @JoinColumn(nullable = false, name = "fk_id_station")
    private Station station;

    public void assignSeasonal() {
        this.seasonal = "Temporada " + station + " " + year;
    }

}
