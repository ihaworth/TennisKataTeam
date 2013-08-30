
public class PostDeuceScorer implements Scorer
{
    private static final String ADVANTAGE_B = "Advantage B";
    private static final String ADVANTAGE_A = "Advantage A";
    private static final String DEUCE = "Deuce";


    public final State deuce = new State() {

        @Override
        void aScores(PostDeuceScorer postDeuceScorer)
        {
            moveToAdvantageA(postDeuceScorer);
        }

        @Override
        void bScores(PostDeuceScorer postDeuceScorer)
        {
            moveToAdvantageB(postDeuceScorer);
        }

        @Override
        public String score()
        {
            return DEUCE;
        }
    };

    public final State advantageA = new State() {

        @Override
        void aScores(PostDeuceScorer postDeuceScorer)
        {
            aWon(postDeuceScorer);
        }

        @Override
        void bScores(PostDeuceScorer postDeuceScorer)
        {
            moveToDeuce(postDeuceScorer);
        }

        @Override
        public String score()
        {
            return ADVANTAGE_A;
        }
    };

    public final State advantageB = new State() {

        @Override
        void aScores(PostDeuceScorer postDeuceScorer)
        {
            moveToDeuce(postDeuceScorer);
        }

        @Override
        void bScores(PostDeuceScorer postDeuceScorer)
        {
            bWon(postDeuceScorer);
        }

        @Override
        public String score()
        {
            return ADVANTAGE_B;
        }
    };

    abstract class State {


        State(){
        }

        public abstract String score();

        abstract void aScores(PostDeuceScorer postDeuceScorer);

        abstract void bScores(PostDeuceScorer postDeuceScorer);

        protected void moveToDeuce(PostDeuceScorer postDeuceScorer)
        {
            postDeuceScorer.state = deuce;
        }

        protected void moveToAdvantageA(PostDeuceScorer postDeuceScorer)
        {
            postDeuceScorer.state = advantageA;
        }

        protected void moveToAdvantageB(PostDeuceScorer postDeuceScorer)
        {
            postDeuceScorer.state = advantageB;
        }

        protected void aWon(PostDeuceScorer postDeuceScorer)
        {
            postDeuceScorer.listener.aWon();
        }

        protected void bWon(PostDeuceScorer postDeuceScorer)
        {
            postDeuceScorer.listener.bWon();
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
        state.aScores(this);
    }

    @Override
    public void playerBScores()
    {
        state.bScores(this);
    }

    @Override
    public void addListener(GameStateListener listener)
    {
        this.listener = listener;
    }
}
