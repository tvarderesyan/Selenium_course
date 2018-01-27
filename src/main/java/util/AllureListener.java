package util;

import Steps.BaseSteps;
import org.junit.runner.notification.Failure;
import ru.yandex.qatools.allure.junit.AllureRunListener;

/**
 * Created by MY on 27.01.2018.
 */
public class AllureListener extends AllureRunListener {
    @Override
    public void testFailure(Failure failure){
        BaseSteps.takeScreenshot();
        super.testFailure(failure);
    }
}
