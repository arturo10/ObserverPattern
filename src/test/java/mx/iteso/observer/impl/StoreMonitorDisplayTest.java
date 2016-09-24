package mx.iteso.observer.impl;

import mx.iteso.observer.Displayable;
import mx.iteso.observer.Scorer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class StoreMonitorDisplayTest {
    private StoreMonitorDisplay storeMonitorDisplay;
    private ScoresData scoresData;
    private ArrayList<Scorer> scorers;
    private Displayable displayable;

    @Before
    public void setUp() {
        scoresData = mock(ScoresData.class);
        displayable=mock(Displayable.class);
        storeMonitorDisplay = new StoreMonitorDisplay(scoresData);
        scorers=new ArrayList<Scorer>();
        scorers.add(new Scorer("Marco",12,"Delantero","Tacit Knowledge"));

    }


    @Test
    public void testUpdate() {
        storeMonitorDisplay.update("homeTeam", "awayTeam", 1, 0,scorers);
        String toVerify="\nMobile is displaying: \n" +
                "Latest score is:homeTeam (HOME) 1 - awayTeam (AWAY) 0\nName:Marco" +
                ", Number: 12" +
                ", Position: Delantero ,Team: Tacit Knowledge";
        Assert.assertEquals(toVerify, storeMonitorDisplay.display());
    }
}
