import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class CreateTestData {
    Random r = new Random();
    Faker f = new Faker();
    List<String> testData = new ArrayList<>();

    public void createPositiveTestDataFile() {
        testData.clear();
        testData.add(LocalDate.now().minusYears(18).format(DateTimeFormatter.ofPattern("ddMMyyyy")));
        testData.add(LocalDate.now().minusYears(18).minusDays(1).format(DateTimeFormatter.ofPattern("ddMMyyyy")));
        testData.add(LocalDate.now().minusYears(19).format(DateTimeFormatter.ofPattern("ddMMyyyy")));
        testData.add(LocalDate.now().minusYears(25).format(DateTimeFormatter.ofPattern("ddMMyyyy")));

        try {
            File file = new File("PositiveBirthdayTestData.txt");
            if (!file.createNewFile()) {
                file.delete();
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter writer = new FileWriter("PositiveBirthdayTestData.txt");
            writer.write(testData.toString().replaceAll("\\[|\\]|,", "").replaceAll(" ", "\n"));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createNegativeTestDataFile() {
        testData.clear();
        testData.add(LocalDate.now().minusYears(18).plusDays(1).format(DateTimeFormatter.ofPattern("ddMMyyyy")));
        testData.add(LocalDate.now().plusDays(r.nextInt(1000)).format(DateTimeFormatter.ofPattern("ddMMyyyy")));
        testData.add(f.numerify("########"));
        testData.add(LocalDate.now().minusYears(9).format(DateTimeFormatter.ofPattern("ddMMyyyy")));
        testData.add(LocalDate.now().minusYears(17).format(DateTimeFormatter.ofPattern("ddMMyyyy")));
        testData.add("00000000");
        try {
            File file = new File("NegativeBirthdayTestData.txt");
            if (!file.createNewFile()) {
                file.delete();
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter writer = new FileWriter("NegativeBirthdayTestData.txt");
            writer.write(testData.toString().replaceAll("\\[|\\]|,", "").replaceAll(" ", "\n"));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Integer> createDrivingExperienceDataFile() {
        HashMap<String, Integer> drivingExperience = new HashMap<>();
        drivingExperience.put(LocalDate.now().minusYears(1).plusDays(r.nextInt(360)).format(DateTimeFormatter.ofPattern("ddMMyyyy")), 1000);
        drivingExperience.put(LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("ddMMyyyy")), 800);
        drivingExperience.put(LocalDate.now().minusYears(1).minusDays(r.nextInt(720)).format(DateTimeFormatter.ofPattern("ddMMyyyy")), 800);
        drivingExperience.put(LocalDate.now().minusYears(3).format(DateTimeFormatter.ofPattern("ddMMyyyy")), 600);
        drivingExperience.put(LocalDate.now().minusYears(3).minusDays(r.nextInt(720)).format(DateTimeFormatter.ofPattern("ddMMyyyy")), 600);
        drivingExperience.put(LocalDate.now().minusYears(5).format(DateTimeFormatter.ofPattern("ddMMyyyy")), 500);
        drivingExperience.put(LocalDate.now().minusYears(5).minusDays(r.nextInt(1800)).format(DateTimeFormatter.ofPattern("ddMMyyyy")), 500);
        drivingExperience.put(LocalDate.now().minusYears(10).format(DateTimeFormatter.ofPattern("ddMMyyyy")), 300);
        drivingExperience.put(LocalDate.now().minusYears(10).minusDays(r.nextInt(2000)).format(DateTimeFormatter.ofPattern("ddMMyyyy")), 300);
        try {
            File file = new File("DrivingExperienceTestData.txt");
            if (!file.createNewFile()) {
                file.delete();
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter writer = new FileWriter("DrivingExperienceTestData.txt");
            writer.write(drivingExperience.keySet().toString().replaceAll("\\[|\\]|,", "").replaceAll(" ", "\n"));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return drivingExperience;
    }
}
