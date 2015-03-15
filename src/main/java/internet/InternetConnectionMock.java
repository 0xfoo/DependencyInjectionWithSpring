package internet;

public class InternetConnectionMock implements InternetConnection {
    @Override
    public boolean isOnline() {
        return true;
    }
}
