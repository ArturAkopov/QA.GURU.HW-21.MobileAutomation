package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:${deviceHost}.properties",
//        "classpath:browserstack.properties"
        "classpath:real.properties"
})
public interface MobileConfig extends Config {

    String mobileUser();

    String mobilePass();

    String mobileApp();

    String mobileDevice();

    String mobilePlatform();

    String mobileProject();

    String mobileBuild();

    String mobileName();

    String mobileUrl();

    String appPackage();

    String appActivity();

    String isDevice();
}
