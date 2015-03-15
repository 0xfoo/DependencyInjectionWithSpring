package periphery;

public class Keyboard {

    private boolean isPlugged;

    Keyboard() {
        isPlugged = true;
    }


    public void plug(){
        isPlugged = true;
    }
    public void unplug(){
        isPlugged = false;
    }

    public boolean isPlugged(){
        return isPlugged;
    }
}
