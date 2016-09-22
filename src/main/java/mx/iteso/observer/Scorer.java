package mx.iteso.observer;

/**
 * Created by Arturo Hernandez on 22/9/2016.
 */
public class Scorer {

    private String Name;
    private int Number;
    private String Position;
    private String Team;

    public Scorer(String name, int number, String position, String team) {
        Name = name;
        Number = number;
        Position = position;
        Team = team;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getTeam() {
        return Team;
    }

    public void setTeam(String team) {
        Team = team;
    }
}
