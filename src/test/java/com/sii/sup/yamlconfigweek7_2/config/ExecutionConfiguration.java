package com.sii.sup.yamlconfigweek7_2.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ExecutionConfiguration {

    private WebDriver webDriver;

    private BrowserConfig.Browser browser;

    private TestEnvironments.Environment environment;

    public ExecutionConfiguration(String browserName, String envName) {
        initBrowserConfig(browserName);
        initEnvironment(envName);

        initializeChrome();
    }

    public ExecutionConfiguration() {
        initBrowserConfig(BrowserName.CHROME.name());
        initEnvironment(EnvName.TEST.name());
        if (browser.getName().equalsIgnoreCase(BrowserName.CHROME.name())) {
            initializeChrome();
        }
    }

    public String getTestTitle() {
        return environment.getTitle();
    }

    public String getWebUrl() {
        return environment.getUrl();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public String getTestEnvironmentName() {
        return environment.getEnvironmentName();
    }

    public void killWebDriver() {
        Set<String> allWebDriverWindows = webDriver.getWindowHandles();
        for (String handle : allWebDriverWindows) {
            webDriver.switchTo().window(handle).close();
        }
    }

    private void initializeChrome() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        browser.getOptions().forEach(options::addArguments);
        options.setExperimentalOption("prefs", browser.getPrefs());
        webDriver = new ChromeDriver(options);
        setWindowSize();

    }

    private void setWindowSize() {
        if (browser.getWindow().equals("maximize")) {
            webDriver.manage().window().maximize();
        }
    }

    private void initBrowserConfig(String browserName) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        File file = new File(Objects.requireNonNull(ExecutionConfiguration.class.getClassLoader().getResource("configuration/browser/browsers.yaml")).getFile());
        BrowserConfig config = null;
        try {
            config = mapper.readValue(file, BrowserConfig.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Access the browsers map
        Map<String, BrowserConfig.Browser> browsers = config.getBrowsers();

        // Access a specific browser by name
        this.browser = browsers.get(browserName.toLowerCase());
    }

    private void initEnvironment(String envName) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        File file = new File(Objects.requireNonNull(ExecutionConfiguration.class.getClassLoader().getResource("configuration/environments/config.yaml")).getFile());
        TestEnvironments config = null;
        try {
            config = mapper.readValue(file, TestEnvironments.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Access the browsers map
        Map<String, TestEnvironments.Environment> testEnvironments = config.getEnvironments();

        // Access a specific browser by name
        this.environment = testEnvironments.get(envName.toLowerCase());
    }
}
