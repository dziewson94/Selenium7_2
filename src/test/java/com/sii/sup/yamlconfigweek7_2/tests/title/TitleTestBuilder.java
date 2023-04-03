package com.sii.sup.yamlconfigweek7_2.tests.title;

import org.openqa.selenium.WebDriver;

public class TitleTestBuilder implements Builder<TestModule> {


    private WebDriver webDriver;

    private String expectedResult;

    private String envName;

    private String url;

    private String testTitle;

    public TitleTestBuilder setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        return this;
    }

    public TitleTestBuilder setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
        return this;
    }

    public TitleTestBuilder setEnvName(String envName) {
        this.envName = envName;
        return this;
    }

    public TitleTestBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public TitleTestBuilder setTestTitle(String testTitle) {
        this.testTitle = testTitle;
        return this;
    }

    public TestModule build() throws IllegalStateException {
        if (webDriver == null || expectedResult == null || envName == null || url == null || testTitle == null) {
            throw new IllegalStateException("Not all required setters have been invoked before calling build()");
        }
        return new TestModule(webDriver, expectedResult, envName, url, testTitle);
    }
}
