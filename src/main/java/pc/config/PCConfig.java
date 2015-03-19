package pc.config;

import internet.config.InternetConnectionConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import internet.InternetConnection;
import org.springframework.context.annotation.Import;
import pc.PC;
import periphery.*;
import periphery.config.KeyboardAndMouseConfig;
import periphery.config.MonitorConfig;
import periphery.config.PowerSupplyConfig;

@Configuration
@Import({InternetConnectionConfig.class, MonitorConfig.class, KeyboardAndMouseConfig.class, PowerSupplyConfig.class})
public class PCConfig {

    @Bean
    public PC pc(InternetConnection internetConnection, Monitor monitor,
                 KeyboardAndMouse keyboardAndMouse, PowerSupply powerSupply) {
        return new PC(internetConnection, monitor, keyboardAndMouse, powerSupply);
    }
}
