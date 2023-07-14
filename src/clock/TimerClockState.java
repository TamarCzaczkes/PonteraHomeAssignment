package clock;

/**
 * Concrete class for the timer state of the clock.
 */
public class TimerClockState extends ClockState {

    @Override
    public void doB() {
        System.out.println("Timer B");
    }

    @Override
    public void doC() {
        System.out.println("Timer C");
    }

    @Override
    public void doD() {
        System.out.println("Timer D");
    }

    @Override
    public ClockState getNextState() {
        return new StopperClockState();
    }
}
