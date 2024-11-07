package tests.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST) //зачититывает первый, а merge — последний
@Config.Sources({
        "classpath:${device}.properties",
        "classpath:mobile.properties"

})

public interface MobileConfig extends Config {

    @Key("device.name")
    String getDeviceName();

    @Key("platform.name")
    String getPlatformName();

    @Key("platform.version")
    String getPlatformVersion();






}
