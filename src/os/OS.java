package os;

public class OS {

    // these are the first nodes of the linked lists
    private static SleepingJobNode sleepingJobs;
    private static JobNode runningJobs;

    // this is the last node of the linked list
    private static JobNode lastRunningJob;

    /**
     * Should put the job in the 'sleepingJobs' data structure.
     *
     * @param job          - the job that goes to sleep
     * @param milliSeconds - the sleeping time of the job
     */
    public static void sleep(Job job, long milliSeconds) {

        // check that job and milliSeconds are valid
        if (job == null || milliSeconds <= 0) {
            System.err.println("ERROR: Invalid arguments were given to OS.sleep function.");
            System.exit(1);
        }

        long time = 0;
        SleepingJobNode prev = null;
        SleepingJobNode curr = sleepingJobs;

        JobNode jobNode = new JobNode(job);

        // find where to insert the new JobNode into the sleepingJobs linked list
        while (curr != null) {

            if (time + curr.timer > milliSeconds) {
                break;
            }

            time += curr.timer;

            // add JobNode to this SleepingJobNode
            if (time == milliSeconds) {
                curr.lastJob.next = jobNode;
                curr.lastJob = jobNode;
                return;
            }

            prev = curr;
            curr = curr.next;
        }

        SleepingJobNode newNode = new SleepingJobNode(milliSeconds - time, curr, jobNode, jobNode);

        if (prev == null) {  // job should be first to wake - insert as first node
            sleepingJobs = newNode;
        } else {
            prev.next = newNode;
        }

        if (newNode.next != null) {
            newNode.next.timer -= newNode.timer;
        }
    }

    /**
     * Should move the jobs from 'sleepingJobs' to 'runningJobs' when the time to sleep is up.
     * Assumption - if this function is called, it means that one ms has passed.
     */
    public static void awake() {
        if (sleepingJobs != null) {
            sleepingJobs.timer -= 1;

            if (sleepingJobs.timer == 0) {

                if (runningJobs == null) {
                    runningJobs = sleepingJobs.jobs;
                } else {
                    lastRunningJob.next = sleepingJobs.jobs;
                }

                lastRunningJob = sleepingJobs.lastJob;
                sleepingJobs = sleepingJobs.next;
            }
        }
    }
}
