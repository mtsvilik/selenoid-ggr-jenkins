package com.solvd.posteducationtaskscarina.service;

import com.qaprosoft.carina.core.foundation.webdriver.core.capability.impl.desktop.ChromeCapabilities;
import com.qaprosoft.carina.core.foundation.webdriver.core.capability.impl.desktop.FirefoxCapabilities;
import com.qaprosoft.carina.core.foundation.webdriver.core.capability.impl.desktop.SafariCapabilities;
import org.openqa.selenium.MutableCapabilities;

public class CapabilityFactory {

    public static MutableCapabilities createCapabilities(String browser) {
        MutableCapabilities mutableCapabilities = null;

        switch (browser) {
            case "chrome":
                mutableCapabilities = new ChromeCapabilities().getCapability("chrome-test");
                break;
            case "firefox":
                mutableCapabilities = new FirefoxCapabilities().getCapability("firefox-test");
                break;
            case "safari":
                mutableCapabilities = new SafariCapabilities().getCapability("safari-test");
                break;
            default:
                break;
        }
        return mutableCapabilities;
    }
}
