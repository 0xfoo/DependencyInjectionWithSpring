package periphery.config;

import org.springframework.context.annotation.Bean;
import periphery.PowerSupply;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PowerSupplyConfig {
    @Bean
    // injecting a mock of PowerSupply through mockito mock
    public PowerSupply powerSupply() {
        PowerSupply mockPowerSupply = mock(PowerSupply.class);
        // default behaviour is false for boolean functions
        when(mockPowerSupply.isOn()).thenReturn(true);
        return mockPowerSupply;
    }
}
