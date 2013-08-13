import static org.mockito.Mockito.*;

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
		
		standardScorer.playerAScores();
		standardScorer.playerAScores();
		standardScorer.playerAScores();
		standardScorer.playerAScores();
		
		verify(listener).aWon();
	}
	
	
	@Test
	public void notifiesWhenBWins() {
		
		standardScorer.playerBScores();
		standardScorer.playerBScores();
		standardScorer.playerBScores();
		standardScorer.playerBScores();
		
		verify(listener).bWon();
	}
}
