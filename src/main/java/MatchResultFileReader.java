import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatchResultFileReader {
    private Scanner scanner;


    public MatchResultFileReader(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        scanner = new Scanner(file);
    }

    public List<MatchResult> readFile() {
        List<MatchResult> matchResults = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            MatchResult matchResult = parseLine(line);
            matchResults.add(matchResult);
        }

        return matchResults;
    }

    private MatchResult parseLine(String line) {
        String[] tokens = line.split(";");
        String teams = tokens[0];
        ArrayList<String> goalScorersList = new ArrayList<>();
        if (tokens.length > 1) {
            String goalScorers = tokens[1];
            for (String gs : goalScorers.split(",")) {
                goalScorersList.add(gs);
            }
        }
        return new MatchResult(teams, goalScorersList);
    }

}




