import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckAge {
    AgeControl control = new AgeControl();
    AgeCalculator ageCalc = new AgeCalculator();
    CreateTestData createTestData = new CreateTestData();

    @Test
    public void positivesTests() throws IOException {
        createTestData.createPositiveTestDataFile();
        List<String> testData = Files.readAllLines(Path.of("./PositiveBirthdayTestData.txt"));
        for (String date : testData) Assertions.assertTrue(control.is18(ageCalc.ageService(date)));
    }

    @Test
    public void negativeTests() throws IOException {
        createTestData.createNegativeTestDataFile();
        List<String> testData = Files.readAllLines(Path.of("./NegativeBirthdayTestData.txt"));
        for (String date : testData) Assertions.assertFalse(control.is18(ageCalc.ageService(date)));
    }

    @Test
    public void driving() {
        HashMap<String, Integer> testData = createTestData.createDrivingExperienceDataFile();
        for (Map.Entry<String, Integer> test : testData.entrySet()) {
            Assertions.assertEquals(test.getValue(), control.insurance(ageCalc.ageService(test.getKey())));
        }
    }
}
