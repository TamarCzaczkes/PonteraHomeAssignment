package clock;

/**
 * Abstract class for the states of the clock.
 */
abstract public class ClockState {

    public abstract void doB();

    public abstract void doC();

    public abstract void doD();

    public abstract ClockState getNextState();

}
