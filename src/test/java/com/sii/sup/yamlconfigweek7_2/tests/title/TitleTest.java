package com.sii.sup.yamlconfigweek7_2.tests.title;

import com.sii.sup.yamlconfigweek7_2.config.ExecutionConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TitleTest {


    private static ExecutionConfiguration executionConfiguration;
    WebDriver webDriver;
    String expectedResult;
    String envName;
    String url;
    String testTitle;

    @BeforeAll
    static void setup() {
        executionConfiguration = new ExecutionConfiguration();
    }

    @AfterAll
    static void tearDown() {
        executionConfiguration.killWebDriver();
    }

    @Test
    void test() {
        TestModule module = new TitleTestBuilder().
                setTestTitle(executionConfiguration.getTestTitle()).
                setUrl(executionConfiguration.getWebUrl()).
                setEnvName(executionConfiguration.getTestEnvironmentName()).
                setWebDriver(executionConfiguration.getWebDriver()).
                setExpectedResult("Onet – Jesteś na bieżąco").build();
        module.execute();
    }
}
