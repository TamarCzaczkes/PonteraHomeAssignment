package clock;

public class Clock {

    private ClockState clockState;

    public Clock() {
        clockState = new AlarmClockState();
    }

    void doA() {
        clockState = clockState.getNextState();
    }

    void doB() {
        clockState.doB();
    }

    void doC() {
        clockState.doC();
    }

    void doD() {
        clockState.doD();
    }

}
