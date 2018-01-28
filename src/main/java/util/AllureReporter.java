package util;

import Steps.BaseSteps;
import gherkin.formatter.model.Result;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.annotations.Attachment;



/**
 * Created by Varderesyan Tsolak on 27.01.2018.
 */
public class AllureReporter extends ru.yandex.qatools.allure.cucumberjvm.AllureReporter {

    @Override
    public void result(Result result) {
        if ("failed".equals(result.getStatus()))
            takeScreenShot();
        super.result(result);
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenShot() {

        return ((TakesScreenshot) BaseSteps.driver()).getScreenshotAs(OutputType.BYTES);
    }


}
