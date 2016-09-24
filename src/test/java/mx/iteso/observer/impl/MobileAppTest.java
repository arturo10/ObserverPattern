package mx.iteso.observer.impl;

import mx.iteso.observer.Scorer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.mockito.Mockito.*;
/**
 * Created by Arturo Hernandez on 24/9/2016.
 */
public class MobileAppTest {

    private MobileApp mobileApp ;
    private ScoresData scoresData;
    private ArrayList<Scorer> scorers;

    @Before
    public void setUp() {
        scoresData = mock(ScoresData.class);
        mobileApp = new MobileApp(scoresData);
        scorers=new ArrayList<Scorer>();
        scorers.add(new Scorer("Marco",12,"Delantero","Tacit Knowledge"));
    }

    @Test
    public void testUpdate() {
        mobileApp.update("homeTeam", "awayTeam", 1, 0,scorers);
        String toVerify="\nMobile is displaying: \n" +
                "Latest score is:homeTeam (HOME) 1 - awayTeam (AWAY) 0\nName:Marco" +
                ", Number: 12" +
                ", Position: Delantero ,Team: Tacit Knowledge";
        Assert.assertEquals(toVerify, mobileApp.display());
    }

    @Test
    public void testUnsuscribe() {
        mobileApp.unsuscribe();
        scoresData.setScore("home","js",2,3,scorers);
        verify(scoresData, times(1)).removeObserver(mobileApp);
    }

    @Test
    public void testActivateNotificationsAgain() {
        mobileApp.unsuscribe();
        scoresData.setScore("Chivas","America",1,4,scorers);
        verify(scoresData, times(1)).removeObserver(mobileApp);
        mobileApp.Suscribe();
        verify(scoresData, times(2)).registerObserver(mobileApp);
    }



}
