import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReaderTest {

    MatchResult matchResult;
    String file = "Euro2024QualifyingRound.csv";
    MatchResultFileReader mFR;

    @BeforeEach
    void setUp(){
        try {
            mFR =  new MatchResultFileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void readFileSize(){
        int expectedSize = 10;
        int actualSize = mFR.readFile().size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void readFirstElement(){
        ArrayList<String> goalscorers = new ArrayList<>();
        goalscorers.add("Højlund");
        goalscorers.add("Højlund");
        goalscorers.add("Højlund");
        MatchResult expectedMatchResult = new MatchResult("Denmark-Finland", goalscorers);
        MatchResult actualMatchResult = mFR.readFile().get(0);
        assertEquals(expectedMatchResult, actualMatchResult);
    }


}
