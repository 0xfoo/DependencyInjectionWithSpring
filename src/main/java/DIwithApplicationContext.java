import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import internet.InternetConnection;
import pc.PC;

@Configuration
@ComponentScan
public class DIwithApplicationContext {

    @Bean
    InternetConnection mockInternetConnection() {
        return new InternetConnection(){
            public boolean isOnline(){
                return false;
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(DIwithApplicationContext.class);
        PC pc = context.getBean(PC.class);
        pc.printStatusReport();
    }
}
