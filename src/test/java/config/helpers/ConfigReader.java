package config.helpers;


import org.aeonbits.owner.ConfigFactory;

public enum ConfigReader {
    Instance;

    private static final WebConfig web =
            ConfigFactory.create(
                    WebConfig.class,
                    System.getProperties()
            );

    public WebConfig read() {
        return web;
    }
}
