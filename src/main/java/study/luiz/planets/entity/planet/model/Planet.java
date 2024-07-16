package study.luiz.planets.entity.planet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Planet {
    private Long id;
    private String name;
    private String climate;
    private String terrain;
    private Integer numberApparitions;

    public Planet(String name, String climate, String terrain, Integer numberApparitions) {
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.numberApparitions = numberApparitions;
    }
}
