package config.helpers;

import config.Browser;
import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:${env}.properties"
})
public interface WebConfig extends Config {
    @Key("browser")
    @DefaultValue("chrome")
    Browser browser();
    @Key("browserVersion")
    @DefaultValue("124.0")
    String browserVersion();
    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();
    @Key("baseUrl")
    String baseUrl();
    @Key("isRemote")
    boolean isRemote();
    @Key("remoteUrl")
    String remoteUrl();
}