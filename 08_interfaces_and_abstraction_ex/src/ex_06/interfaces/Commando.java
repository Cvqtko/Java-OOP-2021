package ex_06.interfaces;

import java.util.List;

public interface Commando {

    void addMission(Mission mission);

    List<Mission> getMissions();

}