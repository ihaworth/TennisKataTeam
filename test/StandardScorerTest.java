import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;


public class StandardScorerTest {

    private StandardScorer standardScorer;
    private GameStateListener listener;

    @Before
    public void setup() {

        listener = mock(GameStateListener.class);

        standardScorer = new StandardScorer();
        standardScorer.addListener(listener);
    }

    @Test
    public void notifiesWhenAWins() {

        playerAScores40();
        standardScorer.playerAScores();

        verify(listener).aWon();
    }


    @Test
    public void notifiesWhenBWins() {

        playerBScores40();
        standardScorer.playerBScores();

        verify(listener).bWon();
    }

    @Test
    public void notifiesWhenATakesScoreToDeuce() {

        playerBScores40();
        playerAScores40();

        verify(listener).deuce();
    }

    @Test
    public void notifiesWhenBTakesScoreToDeuce() {

        playerAScores40();
        playerBScores40();

        verify(listener).deuce();
    }

    private void playerAScores40()
    {
        standardScorer.playerAScores();
        standardScorer.playerAScores();
        standardScorer.playerAScores();
    }

    private void playerBScores40()
    {
        standardScorer.playerBScores();
        standardScorer.playerBScores();
        standardScorer.playerBScores();
    }


}
