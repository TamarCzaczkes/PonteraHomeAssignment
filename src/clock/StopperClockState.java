package clock;

/**
 * Concrete class for the stopper state of the clock.
 */
public class StopperClockState extends ClockState {

    @Override
    public void doB() {
        System.out.println("Stopper B");
    }

    @Override
    public void doC() {
        System.out.println("Stopper C");
    }

    @Override
    public void doD() {
        System.out.println("Stopper D");
    }

    @Override
    public ClockState getNextState() {
        return new AlarmClockState();
    }
}
