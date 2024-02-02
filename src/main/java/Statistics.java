import java.io.FileNotFoundException;
import java.util.*;

public class Statistics {

    private List<MatchResult> matchResults;

    public Statistics(String fileName) throws FileNotFoundException {
    MatchResultFileReader matchResultFileReader = new MatchResultFileReader(fileName);
    matchResults = matchResultFileReader.readFile();
    }


    public Set<String> getGoalScorers() {
        Set<String> goalScorers = new HashSet<>();
        for (MatchResult mr : matchResults){
            for (String goalscorer : mr.getGoalScorers()){
                goalScorers.add(goalscorer);
            }
        }
        return goalScorers;
    }

    public Map<String, Integer> totalGoalsPerPlayer() {
        Map<String, Integer> goalsPerPlayer = new HashMap<>();
        for (MatchResult mr : matchResults){
            for (String goalScorer : mr.getGoalScorers()){
                if (goalsPerPlayer.containsKey(goalScorer)){
                    int goals = goalsPerPlayer.get(goalScorer) +1;
                    goalsPerPlayer.put(goalScorer, goals);

                } else {
                    goalsPerPlayer.put(goalScorer, 1);
                }
            }
        }
        return goalsPerPlayer;
    }

    public int getNumberOfGoals(String goalScorer) {
        if (totalGoalsPerPlayer().get(goalScorer) != null){
            return totalGoalsPerPlayer().get(goalScorer);
        } return 0;
    }


}
