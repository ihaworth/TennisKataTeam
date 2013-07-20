
public class Game {
	
	private int aIndex = 0;
	private int bIndex = 0;
	
	private String[] scores = {"L", "15", "30", "40"};

	public String score() {
		if(isDeuce())
			return "Deuce";
		
		if (aWon())
			return "A WINS";

		if (bWon())
			return "B WINS";
		
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

	public void playerAScores() {
		aIndex++;
	}

	public void playerBScores() {
		bIndex++;
	}

}
