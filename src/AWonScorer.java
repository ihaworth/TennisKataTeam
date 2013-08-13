
public class AWonScorer implements Scorer {


	@Override
	public String score() {
		return "A WINS";
	}

	@Override
	public void playerAScores() {
	}

	@Override
	public void playerBScores() {
	}

	@Override
	public void addListener(GameStateListener listener) {

	}
}
