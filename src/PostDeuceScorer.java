
public class PostDeuceScorer implements Scorer
{
    public final State deuce = new State() {

        @Override
        public void aScores() {
            moveToAdvantageA();
        }

        @Override
        public void bScores() {
            moveToAdvantageB();
        }

        @Override
        public String score() {
            return "Deuce";
        }
    };

    public final State advantageA = new State() {

        @Override
        public void aScores() {
            aWon();
        }

        @Override
        public void bScores() {
            moveToDeuce();
        }

        @Override
        public String score() {
            return "Advantage A";
        }
    };

    public final State advantageB = new State() {

        @Override
        public void aScores() {
            moveToDeuce();
        }

        @Override
        public void bScores() {
            bWon();
        }

        @Override
        public String score() {
            return "Advantage B";
        }
    };

    interface State {

        void aScores();
        void bScores();

        String score();
    }

    protected void moveToDeuce()
    {
        state = deuce;
    }

    protected void moveToAdvantageA()
    {
        state = advantageA;
    }

    protected void moveToAdvantageB()
    {
        state = advantageB;
    }

    protected void aWon()
    {
        listener.aWon();
    }

    protected void bWon()
    {
        listener.bWon();
    }


    private State state = deuce;

    private GameStateListener listener;

    @Override
    public String score()
    {
        return state.score();
    }

    @Override
    public void playerAScores()
    {
        state.aScores();
    }

    @Override
    public void playerBScores()
    {
        state.bScores();
    }

    @Override
    public void addListener(GameStateListener listener)
    {
        this.listener = listener;
    }
}
