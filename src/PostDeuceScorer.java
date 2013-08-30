
public class PostDeuceScorer implements Scorer
{
    private static final String ADVANTAGE_B = "Advantage B";
    private static final String ADVANTAGE_A = "Advantage A";
    private static final String DEUCE = "Deuce";


    public final State deuce = new State(PostDeuceScorer.DEUCE) {

        @Override
        void aScores(PostDeuceScorer postDeuceScorer)
        {
            postDeuceScorer.state = advantageA;
        }

        @Override
        void bScores(PostDeuceScorer postDeuceScorer)
        {
            postDeuceScorer.state = advantageB;
        }
    };

    public final State advantageA = new State(ADVANTAGE_A) {

        @Override
        void aScores(PostDeuceScorer postDeuceScorer)
        {
            postDeuceScorer.listener.aWon();
        }

        @Override
        void bScores(PostDeuceScorer postDeuceScorer)
        {
            postDeuceScorer.state = deuce;
        }
    };

    public final State advantageB = new State(ADVANTAGE_B) {

        @Override
        void aScores(PostDeuceScorer postDeuceScorer)
        {
            postDeuceScorer.state = postDeuceScorer.deuce;
        }

        @Override
        void bScores(PostDeuceScorer postDeuceScorer)
        {
            postDeuceScorer.listener.bWon();
        }
    };

    abstract class State {

        private String score;

        State(String score){
            this.score = score;
        }

        public String score() {
            return score;
        }

        abstract void aScores(PostDeuceScorer postDeuceScorer);

        abstract void bScores(PostDeuceScorer postDeuceScorer);
    }


    private State state = deuce;

    private GameStateListener listener;

    // Conditionals
    // Duplication
    // String comparisons
    // Too many responsibilities???

    @Override
    public String score()
    {
        return state.score();
    }

    @Override
    public void playerAScores()
    {
        state.aScores(this);
    }

    @Override
    public void playerBScores()
    {
        state.bScores(this);
    }

    private boolean isAdvantageA()
    {
        return state == advantageA;
    }

    private boolean isAdvantageB()
    {
        return state == advantageB;
    }

    @Override
    public void addListener(GameStateListener listener)
    {
        this.listener = listener;
    }
}
