package periphery;

public class KeyboardAndMouse {
    private Keyboard keyboard;
    private Mouse mouse;

    /**
     * KeyboardAndMouse are keyboard and mouse, quelle surprise.
     *
     * @param keyboard exactly that
     * @param mouse    exactly that
     */
    public KeyboardAndMouse(Keyboard keyboard, Mouse mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }

    /**
     * Return true if keyboard and mouse are connected, else false
     *
     * @return see above
     */
    public boolean isPlugged() {
        return keyboard.isPlugged() && mouse.isPlugged();
    }
}
