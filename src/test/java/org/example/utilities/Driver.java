package org.example.utilities;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;

import static javax.swing.UIManager.put;

public class Driver {

    public static RemoteWebDriver getRemoteDriver() {
        ChromeOptions options = new ChromeOptions();

        // Versiune Chrome Selenoid
        options.setCapability("browserVersion", "128.0");

        // Optiuni Selenoid
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "Test badge...");
            put("sessionTimeout", "15m");
            put("env", new ArrayList<String>() {{ add("TZ=UTC"); }});
            put("enableVideo", true);
            put("enableVNC", true);
            put("enableLog", true);
        }});

        // Argumente Chrome pentru Linux CI
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        RemoteWebDriver remoteDriver = null;
        try {
            remoteDriver = new RemoteWebDriver(
                    URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                    options
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return remoteDriver;
    }
}
