import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Statistics {

    private List<MatchResult> matchResults;

    public Statistics(String fileName) throws FileNotFoundException {
    MatchResultFileReader matchResultFileReader = new MatchResultFileReader(fileName);
    matchResults = matchResultFileReader.readFile();
    }


    public Set<String> getGoalScorers() {

        return null;
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
