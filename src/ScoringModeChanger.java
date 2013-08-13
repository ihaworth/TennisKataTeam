
final class ScoringModeChanger implements GameStateListener {
	
	private final Game game;

	ScoringModeChanger(Game game) {
		this.game = game;
	}

	@Override
	public void aWon() {
		game.playerAWon();
		
	}

	@Override
	public void bWon() {
		game.playerBWon();
		
	}
}