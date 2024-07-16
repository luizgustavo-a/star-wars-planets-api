package study.luiz.planets.infrasctructure.config.db.schema;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import study.luiz.planets.entity.planet.model.Planet;

@AllArgsConstructor
@NoArgsConstructor
@Entity
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
