package com.sii.sup.yamlconfigweek7_2.config;

import java.util.List;
import java.util.Map;

class BrowserConfig {
    private Map<String, Browser> browsers;

    public Map<String, Browser> getBrowsers() {
        return browsers;
    }

    public void setBrowsers(Map<String, Browser> browsers) {
        this.browsers = browsers;
    }

    static class Browser {
        private String name;
        private String window;
        private List<String> options;
        private Map<String, Object> prefs;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWindow() {
            return window;
        }

        public void setWindow(String window) {
            this.window = window;
        }

        public List<String> getOptions() {
            return options;
        }

        public void setOptions(List<String> options) {
            this.options = options;
        }

        public Map<String, Object> getPrefs() {
            return prefs;
        }

        public void setPrefs(Map<String, Object> prefs) {
            this.prefs = prefs;
        }
    }
}
