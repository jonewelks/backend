package br.com.backend.Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "br.com.backend.Steps",
        tags = "",
        plugin = {
                "pretty",
                "html:reports/evd/cucumber.html",
                "json:target/cucumber.json",
                "junit:reports/evd/cucumber.xml"
        }
)
public class Runner {
}
