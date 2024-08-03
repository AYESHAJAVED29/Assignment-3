
import java.util.Scanner;
public class CricketScorecard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name of Team 1:");
        String team1Name = scanner.nextLine();

        System.out.println("Enter name of Team 2:");
        String team2Name = scanner.nextLine();

        Team team1 = new Team(team1Name);
        Team team2 = new Team(team2Name);

        System.out.println("Enter player names for " + team1Name + ":");
        for (int i = 0; i < 11; i++) {
            team1.addPlayer(i, new Player(scanner.nextLine()));
        }

        System.out.println("Enter player names for " + team2Name + ":");
        for (int i = 0; i < 11; i++) {
            team2.addPlayer(i, new Player(scanner.nextLine()));
        }

        Match match = new Match(team1, team2);
        match.toss();
        match.playInnings();
        
        // Swap batting and bowling teams
        Team temp = match.battingTeam;
        match.battingTeam = match.bowlingTeam;
        match.bowlingTeam = temp;
        
        match.playInnings();
        match.determineWinner();
        
        scanner.close();
    }
}
