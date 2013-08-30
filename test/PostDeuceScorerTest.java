
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;


public class PostDeuceScorerTest
{

    private PostDeuceScorer postDeuceScorer;
    private GameStateListener listener;

    @Before
    public void setup() {
        postDeuceScorer = new PostDeuceScorer();
        listener = mock(GameStateListener.class);
        postDeuceScorer.addListener(listener);
    }

    @Test
    public void scoreIsInitiallyDeuce() {

        assertEquals("Deuce", postDeuceScorer.score());
    }

    @Test
    public void AScoring_TakesFromDeuceToAdvantageA() {

        postDeuceScorer.playerAScores();

        assertEquals("Advantage A", postDeuceScorer.score());
    }


    @Test
    public void BScoring_TakesFromDeuceToAdvantageB() {

        postDeuceScorer.playerBScores();

        assertEquals("Advantage B", postDeuceScorer.score());
    }

    @Test
    public void AScoring_TakesFromAdvantageBToDeuce() {

        postDeuceScorer.playerBScores();

        postDeuceScorer.playerAScores();

        assertEquals("Deuce", postDeuceScorer.score());
    }

    @Test
    public void BScoring_TakesFromAdvantageAToDeuce() {

        postDeuceScorer.playerAScores();

        postDeuceScorer.playerBScores();

        assertEquals("Deuce", postDeuceScorer.score());
    }

    @Test
    public void AScoring_TakesFromAdvantageAToAWon() {

        postDeuceScorer.playerAScores();

        postDeuceScorer.playerAScores();

        verify(listener).aWon();
    }

    @Test
    public void BScoring_TakesFromAdvantageBToBWon() {

        postDeuceScorer.playerBScores();

        postDeuceScorer.playerBScores();

        verify(listener).bWon();
    }
}
