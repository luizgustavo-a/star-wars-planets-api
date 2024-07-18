package study.luiz.planets.infrasctructure.config.db.schema;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import study.luiz.planets.entity.planet.model.Planet;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "planets")
public class PlanetSchema {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String climate;
    private String terrain;
    private Integer numberApparitions;

    public PlanetSchema (Planet planet) {
        this.id = planet.getId();
        this.name = planet.getName();
        this.climate = planet.getClimate();
        this.terrain = planet.getTerrain();
        this.numberApparitions = planet.getNumberApparitions();
    }

    public Planet toModel() {
        return new Planet(this.id, this.name, this.climate, this.terrain, this.numberApparitions);
    }
}
