package mx.iteso.observer;

import mx.iteso.observer.impl.MobileApp;
import mx.iteso.observer.impl.ScoresData;
import mx.iteso.observer.impl.StoreMonitorDisplay;

import java.util.ArrayList;

public class NewsStation {
    public static void main( String[] args ){
        ScoresData scoresData;
        scoresData = new ScoresData();
        MobileApp mobileApp=new MobileApp(scoresData);
        StoreMonitorDisplay monitor=new StoreMonitorDisplay(scoresData);
        ArrayList<Scorer> scorers=new ArrayList<Scorer>();
        scorers.add(new Scorer("Martin",1,"Delantero","Tacit Knowledge"));
        scorers.add(new Scorer("Pedro",1,"Delantero","Tacit Knowledge"));
        mobileApp.unsuscribe();
        scoresData.setScore("Tacit Knowledge", "Intel", 8, 1,scorers);



    }
}
