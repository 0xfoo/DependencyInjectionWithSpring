package internet.config;

import internet.InternetConnection;
import internet.InternetConnectionMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class InternetConnectionConfig {

    @Bean
    // injecting the 'actual' InternetConnectionMock (derived from the InternetConnection interface)
    public InternetConnection internetConnection() {
        return new InternetConnectionMock();
    }
}
