package environment.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "classpath:${env}.properties" })
public interface Environment extends Config {
	@Key("app.url")
	String appUrl();

	@Key("app.username")
	String appUsername();

	@Key("app.password")
	String appPassword();
}
