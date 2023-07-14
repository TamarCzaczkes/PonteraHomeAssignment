package clock;

/**
 * Concrete class for the alarm state of the clock.
 */
public class AlarmClockState extends ClockState {

    @Override
    public void doB() {
        System.out.println("Alarm B");
    }

    @Override
    public void doC() {
        System.out.println("Alarm C");
    }

    @Override
    public void doD() {
        System.out.println("Alarm D");
    }

    @Override
    public ClockState getNextState() {
        return new TimerClockState();
    }

}
