package periphery;

public class Mouse {

    private boolean isPlugged;

    Mouse() {
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
