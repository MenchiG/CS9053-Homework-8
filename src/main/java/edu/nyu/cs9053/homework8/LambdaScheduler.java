package edu.nyu.cs9053.homework8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LambdaScheduler{


    private final List<Job> jobs;

    public LambdaScheduler(Collection<Job> jobs) {
        this.jobs = new ArrayList<>(jobs);
    }

    public List<Job> scheduleJobs() {
        int currentTime = 0;
        List<Job> scheduledJobs = new ArrayList<>();

        //Greedy algorithm choose earliest finish time job every time.
        AscJobFinishTimeComparator comparator = new AscJobFinishTimeComparator();
        Collections.sort(jobs, comparator);

        for (Job job : jobs) {
            if(job.getStartTime() >= currentTime) {
                currentTime = job.getFinishTime();
                scheduledJobs.add(job);
            }
        }

        return scheduledJobs;
    }
}