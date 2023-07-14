package os;

/**
 * Linked list of sleeping jobs, where each node contains all the jobs that need to wake up at the same time.
 */
public class SleepingJobNode {

    long timer;
    SleepingJobNode next;
    JobNode jobs;
    JobNode lastJob;

    public SleepingJobNode(long timer, SleepingJobNode next, JobNode jobs, JobNode lastJob) {
        this.timer = timer;
        this.next = next;
        this.jobs = jobs;
        this.lastJob = lastJob;
    }
}
