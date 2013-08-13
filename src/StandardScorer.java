
public class StandardScorer implements Scorer {

	private int aIndex = 0;
	private int bIndex = 0;
	
	private String[] scores = {"L", "15", "30", "40"};
	private GameStateListener listener;

	@Override
	public String score() {
		if(isDeuce())
			return "Deuce";

		return scores[aIndex] + "-" + scores[bIndex];
	}

	private boolean bWon() {
		return bIndex == 4;
	}

	private boolean aWon() {
		return aIndex == 4;
	}

	private boolean isDeuce() {
		return aIndex == 3 && bIndex == 3;
	}

	@Override
	public void playerAScores() {
		aIndex++;
		
		if (aWon()) {
			listener.aWon();
		}
		
	}

	@Override
	public void playerBScores() {
		bIndex++;
		
		if(bWon()) {
			listener.bWon();
		}
	}

	@Override
	public void addListener(GameStateListener listener) {
		this.listener = listener;
	}
}
