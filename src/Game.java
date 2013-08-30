
public class Game {

    private Scorer scorer = new StandardScorer();

    public Game() {
        scorer.addListener(new ScoringModeChanger(this));
    }

    public void playerAScores() {
        scorer.playerAScores();
    }

    public void playerBScores() {
        scorer.playerBScores();
    }

    public String score() {
        return scorer.score();
    }

    public void playerAWon() {
        scorer = new AWonScorer();
    }

    public void playerBWon() {
        scorer = new BWonScorer();
    }

    public void deuce() {
        scorer = new PostDeuceScorer();
        scorer.addListener(new ScoringModeChanger(this));
    }
}
