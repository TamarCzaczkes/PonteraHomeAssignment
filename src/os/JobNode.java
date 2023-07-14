package os;

/**
 * Linked list of jobs.
 */
public class JobNode {

    Job job;
    JobNode next;

    public JobNode(Job job) {
        this.job = job;
    }
}
