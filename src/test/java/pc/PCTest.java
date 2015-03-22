package pc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pc.config.AllInOneConfig;
import pc.config.PCConfig;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AllInOneConfig.class)
public class PCTest {

    @Autowired
    PC testPC;

    @Test
    public void testPCCreationThroughAutoWiring() {
        assertTrue(testPC.isConnectedToTheInternet());
        assertTrue(testPC.isMonitorWorking());
        assertTrue(testPC.isKeyboardAndMousePluggedIn());
        assertTrue(testPC.isPowerSupplied());
    }

    @Test
    public void testPCCreationThroughAllInOneJavaConfig() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AllInOneConfig.class);
        PC pc = context.getBean(PC.class);
        assertTrue(pc.isConnectedToTheInternet());
        assertTrue(pc.isMonitorWorking());
        assertTrue(pc.isKeyboardAndMousePluggedIn());
        assertTrue(pc.isPowerSupplied());
    }

    @Test
    public void testPCCreationThroughModularJavaConfig() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(PCConfig.class);
        PC pc = context.getBean(PC.class);
        assertTrue(pc.isConnectedToTheInternet());
        assertTrue(pc.isMonitorWorking());
        assertTrue(pc.isKeyboardAndMousePluggedIn());
        assertTrue(pc.isPowerSupplied());
    }

    @Test
    public void testPCCreationThroughXMLConfig() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("pc.xml");
        PC pc = context.getBean(PC.class);
        assertTrue(!pc.isConnectedToTheInternet());
        assertTrue(!pc.isMonitorWorking());
        assertTrue(pc.isKeyboardAndMousePluggedIn());
        assertTrue(pc.isPowerSupplied());
    }

}