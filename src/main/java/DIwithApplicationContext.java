import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pc.PC;
import pc.config.PCConfig;

public class DIwithApplicationContext {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(PCConfig.class);
        PC pc = context.getBean(PC.class);
        pc.printStatusReport();
    }
}
