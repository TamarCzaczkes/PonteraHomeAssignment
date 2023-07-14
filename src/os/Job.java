package os;

public class Job {

    // A function for sleep which called by a job
    public void sleep(long ms)  {
        OS.sleep(this, ms);
    }

}
