package com.monoova;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/com/monoova/feature/Monoova.feature"},
        strict = false, plugin = {"pretty",
        "json:target/cucumber_json_reports/monoova.json",
        "html:target/monoova-html"},
        glue = {"com.monoova.driver",
                "com.monoova.steps"})
public class MonoovaCucumberTest {
}
