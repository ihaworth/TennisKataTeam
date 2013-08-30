
public class PostDeuceScorer implements Scorer
{
    private static final String ADVANTAGE_B = "Advantage B";
    private static final String ADVANTAGE_A = "Advantage A";
    private static final String DEUCE = "Deuce";

    private String score = DEUCE;
    private GameStateListener listener;

    @Override
    public String score()
    {
        return score;
    }

    @Override
    public void playerAScores()
    {
        if(score.equals(ADVANTAGE_B))
            score = DEUCE;
        else if(score.equals(ADVANTAGE_A))
            listener.aWon();
        else
            score = ADVANTAGE_A;
    }

    @Override
    public void playerBScores()
    {
        if(score.equals(ADVANTAGE_A))
            score = DEUCE;
        else if (score.equals(ADVANTAGE_B))
            listener.bWon();
        else
            score = ADVANTAGE_B;
    }

    @Override
    public void addListener(GameStateListener listener)
    {
        this.listener = listener;
    }
}
