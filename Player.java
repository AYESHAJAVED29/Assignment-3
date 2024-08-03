
public class Player {
    String name;
    int runs;
    int ballsFaced;
    boolean isOut;

    public Player(String name) {
        this.name = name;
        this.runs = 0;
        this.ballsFaced = 0;
        this.isOut = false;
    }

    public void addRuns(int runs) {
        this.runs += runs;
    }

    public void addBallsFaced() {
        this.ballsFaced++;
    }

    public double getStrikeRate() {
        return (ballsFaced > 0) ? (runs / (double) ballsFaced) * 100 : 0.0;
    }

    public void setOut() {
        this.isOut = true;
    }

    @Override
    public String toString() {
        return name + ": " + runs + " (" + ballsFaced + " balls)" +
                (isOut ? " Out" : " Not Out") +
                ", Strike Rate: " + String.format("%.2f", getStrikeRate());
    }
}
