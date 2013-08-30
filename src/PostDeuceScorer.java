
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

    public final State advantageB = new State(ADVANTAGE_B);

    class State {

        private String score;

        State(String score){
            this.score = score;
        }

        public String score() {
            return score;
        }

        void aScores(PostDeuceScorer postDeuceScorer)
        {
            if(postDeuceScorer.isAdvantageB()) {
                postDeuceScorer.state = postDeuceScorer.deuce;
            } else if(postDeuceScorer.isAdvantageA()) {
                postDeuceScorer.listener.aWon();
            } else {
                postDeuceScorer.state = this;
            }
        }

        void bScores(PostDeuceScorer postDeuceScorer)
        {
            if (postDeuceScorer.isAdvantageA()) {
                postDeuceScorer.state = postDeuceScorer.deuce;
            }
            else if (postDeuceScorer.isAdvantageB()) {
                postDeuceScorer.listener.bWon();
            } else  {
                postDeuceScorer.state = postDeuceScorer.advantageB;
            }
        }
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
        advantageA.aScores(this);
    }

    @Override
    public void playerBScores()
    {
        advantageA.bScores(this);
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
