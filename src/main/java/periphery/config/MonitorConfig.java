package periphery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import periphery.Monitor;


@Configuration
public class MonitorConfig {

    @Bean
    // injecting a Monitor that is working (default is not) even though Monitor is not an interface
    public Monitor monitor() {
        return new Monitor() {
            public boolean isWorking(){
                return true;
            }
        };
    }
}
