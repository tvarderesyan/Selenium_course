import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Varderesyan Tsolak on 28.01.2018.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/"}, glue = {"Steps"},
        plugin = {
                "util.AllureReporter",
        }
)
public class CucumberRunner {
}
