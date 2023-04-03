package com.sii.sup.yamlconfigweek7_2.tests.title;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;


class TestModule extends TitleTest {
    private static final Logger logger = LoggerFactory.getLogger(TitleTest.class.getSimpleName());

    TestModule(WebDriver webDriver, String expectedResult, String envName, String url, String testTitle) {
        this.webDriver = webDriver;
        this.expectedResult = expectedResult;
        this.envName = envName;
        this.url = url;
        this.testTitle = testTitle;
    }

    public void execute() {
        webDriver.get(url);
        logger.info(String.format("Execution:%nTest:%s%nExecution environment:%s%nPage: %s", testTitle, envName, url));
        logger.info(String.format("Result:%nActual page title:%s%nExpected page title:%s", webDriver.getTitle(), expectedResult));
        assertThat(webDriver.getTitle()).isEqualTo(expectedResult);
    }
}
