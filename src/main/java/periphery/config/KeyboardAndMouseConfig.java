package periphery.config;

import org.springframework.context.annotation.Bean;
import periphery.Keyboard;
import periphery.KeyboardAndMouse;
import periphery.Mouse;

public class KeyboardAndMouseConfig {
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
