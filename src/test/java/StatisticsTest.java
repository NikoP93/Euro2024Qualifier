import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticsTest {
    String file = "Euro2024QualifyingRound.csv";
    Statistics statistics;

    @BeforeEach
    void SetUp(){
        try {
            statistics = new Statistics(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void getGoalscorers(){
        int expectedSize = 8;
        int actualSize = statistics.getGoalScorers().size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void totalGoalsPerPlayer(){
        int expectedSize = 7;
        int actualSize = statistics.totalGoalsPerPlayer().get("Højlund");
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void getNumberOfGoals(){
        int expectedSize = 7;
        int actualSize = statistics.getNumberOfGoals("Højlund");
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void getNumberOfGoals0(){
        int expectedSize = 0;
        int actualSize = statistics.getNumberOfGoals("Dolberg");
        assertEquals(expectedSize,actualSize);
    }

}
