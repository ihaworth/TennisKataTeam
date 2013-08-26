import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class PostDeuceScorerTest
{

    private PostDeuceScorer postDeuceScorer;

    @Before
    public void setup() {
        postDeuceScorer = new PostDeuceScorer();
    }

    @Test
    public void scoreIsInitiallyDeuce() {

        assertEquals(postDeuceScorer.score(), "Deuce");
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

        assertEquals(postDeuceScorer.score(), "Deuce");
    }

    @Test
    public void BScoring_TakesFromAdvantageAToDeuce() {

        postDeuceScorer.playerAScores();

        postDeuceScorer.playerBScores();

        assertEquals(postDeuceScorer.score(), "Deuce");
    }


}
