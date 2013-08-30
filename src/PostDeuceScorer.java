
public class PostDeuceScorer implements Scorer
{
    interface State {
        void aScores();
        void bScores();

        String score();
    }

    public final State deuce = new State() {

        @Override public void aScores() {
            state = advantageA;
        }

        @Override public void bScores() {
            state = advantageB;
        }

        @Override public String score() {
            return "Deuce";
        }
    };

    public final State advantageA = new State() {

        @Override public void aScores() {
            listener.aWon();
        }

        @Override public void bScores() {
            state = deuce;
        }

        @Override public String score() {
            return "Advantage A";
        }
    };

    public final State advantageB = new State() {

        @Override public void aScores() {
            state = deuce;
        }

        @Override public void bScores() {
            listener.bWon();
        }

        @Override public String score() {
            return "Advantage B";
        }
    };

    private State state = deuce;

    private GameStateListener listener;

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
    public String score()
    {
        return state.score();
    }

    @Override
    public void addListener(GameStateListener listener)
    {
        this.listener = listener;
    }
}
