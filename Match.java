
import java.util.Random;
public class Match{
    Team team1;
    Team team2;
    Team battingTeam;
    Team bowlingTeam;
    Random random;

    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        this.random = new Random();
    }

    public void toss() {
        if (random.nextBoolean()) {
            battingTeam = team1;
            bowlingTeam = team2;
        } else {
            battingTeam = team2;
            bowlingTeam = team1;
        }
        System.out.println(battingTeam.name + " wins the toss and will bat first.");
    }

    public void playInnings() {
        int maxOvers = 20;
        int ballsPerOver = 6;

        for (int over = 0; over < maxOvers; over++) {
            System.out.println("Over " + (over + 1) + ":");
            for (int ball = 0; ball < ballsPerOver; ball++) {
                if (battingTeam.wickets == 10) break;

                int batsmanIndex = getBatsmanIndex(battingTeam);
                Player batsman = battingTeam.getPlayer(batsmanIndex);
                int runsScored = random.nextInt(7); // 0 to 6 runs

                if (runsScored == 0 && random.nextBoolean()) {
                    // Wicket falls
                    System.out.println(batsman.name + " is out!");
                    batsman.setOut();
                    battingTeam.addWicket();
                } else {
                    batsman.addRuns(runsScored);
                    batsman.addBallsFaced();
                    battingTeam.addRuns(runsScored);
                }

                System.out.println(batsman.name + " scores " + runsScored + " runs.");
            }

            battingTeam.addOver();
            if (battingTeam.wickets == 10) break;
        }

        System.out.println("\n" + battingTeam);
    }

    private int getBatsmanIndex(Team team) {
        for (int i = 0; i < team.players.length; i++) {
            if (!team.getPlayer(i).isOut) {
                return i;
            }
        }
        return -1; // Should not happen, as we check for wickets == 10
    }

    public void determineWinner() {
        if (team1.totalRuns > team2.totalRuns) {
            System.out.println(team1.name + " wins the match!");
        } else if (team2.totalRuns > team1.totalRuns) {
            System.out.println(team2.name + " wins the match!");
        } else {
            System.out.println("The match is a tie!");
        }
    }
}