import java.util.List;
import java.util.Objects;

public class MatchResult {
    private String team;
    private List<String> goalsScorers;

    public MatchResult(String team, List<String> goalsScorers) {
        this.team = team;
        this.goalsScorers = goalsScorers;
    }

    public List<String> getGoalScorers() {
        return goalsScorers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatchResult that)) return false;
        return Objects.equals(team, that.team) && Objects.equals(goalsScorers, that.goalsScorers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(team, goalsScorers);
    }
}
