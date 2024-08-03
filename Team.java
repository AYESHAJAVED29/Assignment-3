
public class Team {
    String name;
    Player[] players;
    int totalRuns;
    int wickets;
    int oversBowled;

    public Team(String name) {
        this.name = name;
        this.players = new Player[11];
        this.totalRuns = 0;
        this.wickets = 0;
        this.oversBowled = 0;
    }

    public void addPlayer(int index, Player player) {
        players[index] = player;
    }

    public Player getPlayer(int index) {
        return players[index];
    }

    public void addRuns(int runs) {
        totalRuns += runs;
    }

    public void addWicket() {
        wickets++;
    }

    public void addOver() {
        oversBowled++;
    }

    @Override
    public String toString() {
        StringBuilder scorecard = new StringBuilder();
        scorecard.append("Scorecard for ").append(name).append(":\n");
        for (Player player : players) {
            if (player != null) {
                scorecard.append(player).append("\n");
            }
        }
        scorecard.append("Total score: ").append(totalRuns).append("/").append(wickets)
                .append(" in ").append(oversBowled).append(" overs\n");
        return scorecard.toString();
    }
}
