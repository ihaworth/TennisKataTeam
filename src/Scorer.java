public interface Scorer {

	String score();

	void playerAScores();
	void playerBScores();

	void addListener(GameStateListener listener);
}