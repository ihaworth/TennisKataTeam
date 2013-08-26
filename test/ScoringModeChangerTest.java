import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;


public class ScoringModeChangerTest {

    private Game game;
    private ScoringModeChanger scoringModeChanger;

    @Before
    public void setUp(){
        game = mock(Game.class);
        scoringModeChanger = new ScoringModeChanger(game);
    }

    @Test
    public void whenAWinsTheGameIsToldToChangeItsScoringModeToTheAWonImplementation() {

        scoringModeChanger.aWon();

        verify(game).playerAWon();
    }


    @Test
    public void whenBWinsTheGameIsToldToChangeItsScoringModeToTheAWonImplementation() {

        scoringModeChanger.bWon();

        verify(game).playerBWon();
    }

    @Test
    public void whenDeuceThenNotifyGame(){

        scoringModeChanger.deuce();

        verify(game).deuce();
    }

}
