package mx.iteso.observer.impl;

import mx.iteso.observer.Displayable;
import mx.iteso.observer.Observer;
import mx.iteso.observer.Scorer;
import mx.iteso.observer.Subject;

import java.util.ArrayList;

public class StoreMonitorDisplay implements Observer, Displayable {
    private String homeTeam;
    private String awayTeam;
    private int homeGoals;
    private int awayGoals;
    private Subject scoresData;
    private ArrayList<Scorer> scorers;

    public StoreMonitorDisplay(Subject scoresData){
        this.scoresData = scoresData;
        this.scoresData.registerObserver(this);
        this.scorers=new ArrayList<Scorer>();
    }

    public String display() {
        String print="\n"+"Mobile is displaying: \n"+"Latest score is:"+homeTeam + " (HOME) " + homeGoals + " - "
                + awayTeam + " (AWAY) " + awayGoals;

        for(Scorer scorer: scorers){
            print+="\nName:"+ scorer.getName()+ ", Number: "+
                    String.valueOf(scorer.getNumber())+ ", Position: "+ scorer.getPosition()+ " ,Team: "+ scorer.getTeam();

        }

        System.out.println(print);
        return print;

    }

    public void update(String home, String away, int homeGoals, int awayGoals,ArrayList<Scorer> scorers) {
        this.homeTeam = home;
        this.awayTeam = away;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.scorers=scorers;
        display();
    }

}
