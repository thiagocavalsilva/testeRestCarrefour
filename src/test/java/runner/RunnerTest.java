package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        tags = "@usuarios",
        glue = {"passos", "hooks"},
        plugin = {"json:target/reports/cucumberReports.json", "pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerTest {

}
