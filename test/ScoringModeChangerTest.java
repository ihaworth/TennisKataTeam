import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;


public class ScoringModeChangerTest {

	@Test
	public void whenAWinsTheGameIsToldToChangeItsScoringModeToTheAWonImplementation() {
		Game game = mock(Game.class);
		ScoringModeChanger scoringModeChanger = new ScoringModeChanger(game);
		
		scoringModeChanger.aWon();
		
		verify(game).playerAWon();
	}

	
	@Test
	public void whenBWinsTheGameIsToldToChangeItsScoringModeToTheAWonImplementation() {
		Game game = mock(Game.class);
		ScoringModeChanger scoringModeChanger = new ScoringModeChanger(game);
		
		scoringModeChanger.bWon();
		
		verify(game).playerBWon();
	}

}
