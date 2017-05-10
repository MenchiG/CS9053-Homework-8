package edu.nyu.cs9053.homework8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LambdaScheduler{


    public static List<Job> scheduleJobs(List<Job> jobs) {

        if ((jobs == null) || jobs.isEmpty() || jobs.contains(null)) {
            throw new IllegalArgumentException();
        }

        int currentTime = 0;
        List<Job> needScheduledJobs = new ArrayList<>(jobs);
        List<Job> scheduledJobs = new ArrayList<>();

        //Greedy algorithm choose earliest finish time job every time.
        AscJobFinishTimeComparator comparator = new AscJobFinishTimeComparator();
        Collections.sort(needScheduledJobs, comparator);

        for (Job job : needScheduledJobs) {
            if(job.getStartTime() >= currentTime) {
                currentTime = job.getFinishTime();
                scheduledJobs.add(job);
            }
        }

        return scheduledJobs;
    }
}