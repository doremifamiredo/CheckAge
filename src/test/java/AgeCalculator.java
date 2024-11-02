import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AgeCalculator {
    public int ageService(String value) {
        open("https://oncalc.ru/calc/kalkulator-vozrasta");
        $("#c_date").setValue(value);
        $(".caption input").click();
        $("#result").shouldBe(Condition.visible);
        String result = $("#result").getText();
        int finishIndex = result.indexOf(",");
        return Integer.parseInt(result.substring(5, finishIndex));
    }
}
