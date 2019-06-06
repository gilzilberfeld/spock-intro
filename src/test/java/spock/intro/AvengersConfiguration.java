package spock.intro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AvengersConfiguration {

	@Bean
	public MCUController mcuController() {
		return new MCUController();
	}
}
