package pc.config;

import internet.InternetConnection;
import internet.InternetConnectionMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pc.PC;
import periphery.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Configuration
public class AllInOneConfig {

    @Bean
    public PC pc() {
        return new PC(internetConnection(), monitor(), keyboardAndMouse(), powerSupply());
    }

    @Bean
    // injecting the 'actual' InternetConnectionMock (derived from the InternetConnection interface)
    public InternetConnection internetConnection() {
        return new InternetConnectionMock();
    }

    @Bean
    // injecting a Monitor that is working (default is not) even though Monitor is not an interface
    public Monitor monitor() {
        return new Monitor() {
            public boolean isWorking(){
                return true;
            }
        };
    }

    @Bean
    // injecting a mock of PowerSupply through mockito mock
    public PowerSupply powerSupply() {
        PowerSupply mockPowerSupply = mock(PowerSupply.class);
        // default behaviour is false for boolean functions
        when(mockPowerSupply.isOn()).thenReturn(true);
        return mockPowerSupply;
    }

    @Bean
    // KeyboardAndMouse is obviously stupid, it is just to show the nesting of injection
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
