package pc.config;

import internet.InternetConnection;
import internet.InternetConnectionMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pc.PC;
import periphery.*;

@Configuration
public class PCConfig {

    @Bean
    public PC pc() {
        return new PC(internetConnection(), monitor(), keyboardAndMouse(), powerSupply());
    }

    @Bean
    public InternetConnection internetConnection() {
        return new InternetConnectionMock();
    }

    @Bean
    public Monitor monitor() {
        return new Monitor();
    }

    @Bean
    public PowerSupply powerSupply() {
        return new PowerSupply();
    }

    @Bean
    public KeyboardAndMouse keyboardAndMouse() {
        return new KeyboardAndMouse(keyboard(), mouse());
    }

    @Bean
    public Keyboard keyboard() {
        return new Keyboard();
    }

    @Bean
    public Mouse mouse() {
        return new Mouse();
    }
}
