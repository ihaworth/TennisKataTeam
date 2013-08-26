
public class PostDeuceScorer implements Scorer
{

    private String score = "Deuce";

    @Override
    public String score()
    {
        return score;
    }

    @Override
    public void playerAScores()
    {
        if(score.equals("Advantage B"))
            score = "Deuce";
        else
            score = "Advantage A";
    }

    @Override
    public void playerBScores()
    {
        if(score.equals("Advantage A"))
            score = "Deuce";
        else
            score = "Advantage B";
    }

    @Override
    public void addListener(GameStateListener listener)
    {
    }

}
