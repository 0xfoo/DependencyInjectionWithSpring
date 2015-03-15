package pc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import internet.InternetConnection;
import periphery.KeyboardAndMouse;
import periphery.Monitor;
import periphery.PowerSupply;

@Component
public class PC {

    private InternetConnection internetConnection;
    private Monitor monitor;
    private KeyboardAndMouse keyboardAndMouse;
    private PowerSupply powerSupply;

    /**
     * Constructor for PC need power supply, monitor, internet connection, keyboard and mouse
     *
     * @param internetConnection internet connection
     * @param monitor monitor
     * @param keyboardAndMouse keyboard and mouse
     * @param powerSupply power supply
     */
    @Autowired
    PC(InternetConnection internetConnection, Monitor monitor,
       KeyboardAndMouse keyboardAndMouse, PowerSupply powerSupply){
        this.internetConnection = internetConnection;
        this.monitor = monitor;
        this.keyboardAndMouse = keyboardAndMouse;
        this.powerSupply = powerSupply;
    }

    boolean isConnectedToTheInternet(){
        return internetConnection.isOnline();
    }

    boolean isMonitorWorking(){
        return monitor.isWorking();
    }

    boolean isKeyboardAndMousePluggedIn(){
        return keyboardAndMouse.isPlugged();
    }

    boolean isPowerSupplied(){
        return powerSupply.isOn();
    }

    public void printStatusReport(){
        String internetStatus = isConnectedToTheInternet() ? "": "not" + " connected.";
        System.out.println("Internet is " + internetStatus);

        String monitorStatus = isMonitorWorking() ? "": "not" + " working.";
        System.out.println("Monitor is " + monitorStatus);

        String keyboardAndMouseStatus = isKeyboardAndMousePluggedIn() ? "": "not" + " plugged.";
        System.out.println("Keyboard and Mouse are " + keyboardAndMouseStatus);

        String powerSupplyStatus = isPowerSupplied() ? "": "not" + " supplied.";
        System.out.println("Power is " + powerSupplyStatus);
    }
}
