package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthConfig;
import config.BrowserStackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackDriver implements WebDriverProvider {

    private static final BrowserStackConfig config =
            ConfigFactory.create(
                    BrowserStackConfig.class,
                    System.getProperties()
            );

    private static final AuthConfig authConfig =
            ConfigFactory.create(
                    AuthConfig.class,
                    System.getProperties()
            );

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        return getBrowserStackDriver();
    }

    public RemoteWebDriver getBrowserStackDriver() {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", authConfig.user());
        caps.setCapability("browserstack.key", authConfig.pass());
        caps.setCapability("app", config.browserstackMobileApp());
        caps.setCapability("device", config.browserstackDeviceName());
        caps.setCapability("os_version", config.browserstackOsVersion());
        caps.setCapability("project", config.browserstackProject());
        caps.setCapability("build", config.browserstackBuild());
        caps.setCapability("name", config.browserstackName());
        caps.setCapability("language",config.browserstackLanguage());
        caps.setCapability("locale",config.browserstackLocale());

        try {
            return new RemoteWebDriver(
                    new URL(config.remoteUrl()), caps);
        } catch (
                MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
