package pc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pc.config.PCConfig;

import static org.junit.Assert.*;

public class PCTest {

    @Test
    public void testPCCreationThroughApplicationContext() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(PCConfig.class);
        PC pc = context.getBean(PC.class);
        assertTrue(pc.isConnectedToTheInternet());
        assertTrue(pc.isMonitorWorking());
        assertTrue(pc.isKeyboardAndMousePluggedIn());
        assertTrue(pc.isPowerSupplied());
    }

    @Test
    public void testPCCreationThroughXMLContext() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("pc.xml");
        PC pc = context.getBean(PC.class);
        assertTrue(!pc.isConnectedToTheInternet());
        assertTrue(!pc.isMonitorWorking());
        assertTrue(pc.isKeyboardAndMousePluggedIn());
        assertTrue(pc.isPowerSupplied());
    }

}