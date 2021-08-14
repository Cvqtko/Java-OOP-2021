package spaceStation.models.mission;

import java.util.List;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

public interface Mission {
    void explore(Planet planet, List<Astronaut> astronauts);
}
