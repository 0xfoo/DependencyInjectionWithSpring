import org.springframework.context.support.ClassPathXmlApplicationContext;

import pc.PC;

public class DIwithXmlContext {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("pc.xml");
        PC pc = context.getBean(PC.class);
        pc.printStatusReport();
        context.close();
    }
}