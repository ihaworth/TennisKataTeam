import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;
	
	@Before
	public void setup() {
		game = new Game();
	}

	@Test
	public void initialScoreIsLoveAll() {
		assertEquals("L-L", game.score());
	}
	
	@Test
	public void playerAScores15Love() {
		game.playerAScores();
		assertEquals("15-L", game.score());
	}
	
	@Test
	public void playerBScores15Love() {
		game.playerBScores();
		assertEquals("L-15", game.score());
	}
	
	@Test
	public void playerAScoresTwice() {
		game.playerAScores();
		game.playerAScores();
		assertEquals("30-L", game.score());
	}
	
	@Test
	public void playerAScoresThenPlayerBScoresGives15All() {
		game.playerAScores();
		game.playerBScores();
		assertEquals("15-15", game.score());
	}
	
	@Test
	public void playerBScoresThenPlayerAScoresGives15All() {
		game.playerBScores();
		game.playerAScores();
		assertEquals("15-15", game.score());
	}	
	
	@Test
	public void playerBScoresTwice() {
		game.playerBScores();
		game.playerBScores();
		assertEquals("L-30", game.score());
	}
	
	@Test
	public void playerAScoresThreeTimes() {
		game.playerAScores();
		game.playerAScores();
		game.playerAScores();
		assertEquals("40-L", game.score());
	}

	@Test
	public void playerAScoresFourTimesAndWins() {
		game.playerAScores();
		game.playerAScores();
		game.playerAScores();
		game.playerAScores();
		assertEquals("A WINS", game.score());
	}

	@Test
	public void playerBScoresFourTimesAndWins() {
		game.playerBScores();
		game.playerBScores();
		game.playerBScores();
		game.playerBScores();
		assertEquals("B WINS", game.score());
	}
	
	@Test
	public void bothPlayersScoreFortyAndTheScoreIsDeuce() {
		game.playerAScores();
		game.playerAScores();
		game.playerAScores();

		game.playerBScores();
		game.playerBScores();
		game.playerBScores();
		
		assertEquals("Deuce", game.score());
	}
}
