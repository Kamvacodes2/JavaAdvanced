import java.util.*;

public class SoccerLeague {
    private Map<String, Team> teamMap;
    private Random random;

    public SoccerLeague() {
        teamMap = new TreeMap<>();
        random = new Random();
    }

    // Generate realistic soccer scores
    private int generateRandomScore() {
        return random.nextInt(6); // Scores between 0 and 5
    }

    // Randomly determine the match result and update points
    private void playRandomMatch(String team1Name, String team2Name) {
        // Add teams to map if they don't exist
        teamMap.putIfAbsent(team1Name, new Team(team1Name));
        teamMap.putIfAbsent(team2Name, new Team(team2Name));

        // Generate random scores
        int team1Score = generateRandomScore();
        int team2Score = generateRandomScore();

        System.out.println(team1Name + " " + team1Score + ", " + team2Name + " " + team2Score);

        // Update points based on the result
        if (team1Score > team2Score) {
            teamMap.get(team1Name).addPoints(3);
        } else if (team1Score < team2Score) {
            teamMap.get(team2Name).addPoints(3);
        } else {
            teamMap.get(team1Name).addPoints(1);
            teamMap.get(team2Name).addPoints(1);
        }
    }

    public void playMatches(List<String> teams) {
        for (int i = 0; i < teams.size(); i += 2) {
            String team1 = teams.get(i);
            String team2 = teams.get(i + 1);
            playRandomMatch(team1, team2);
        }
    }

    public void printRanking() {
        List<Team> ranking = new ArrayList<>(teamMap.values());
        Collections.sort(ranking);

        int rank = 1;
        for (int i = 0; i < ranking.size(); i++) {
            if (i > 0 && ranking.get(i).getPoints() != ranking.get(i - 1).getPoints()) {
                rank = i + 1; // Adjust rank only when points are different
            }
            System.out.println(rank + ". " + ranking.get(i));
        }
    }

    public static void main(String[] args) {
        SoccerLeague league = new SoccerLeague();

        // List of teams for the league
        List<String> teams = Arrays.asList(
                "Liverpool", "ManchesterUnited",
                "Tarantulas2", "FC Awesome",
                "Lions", "FCAwesome",
                "Grouches", "Tarantulas2"
        );

        // Play random matches
        league.playMatches(teams);

        // Print final ranking
        System.out.println("\nFinal Rankings:");
        league.printRanking();
    }
}
