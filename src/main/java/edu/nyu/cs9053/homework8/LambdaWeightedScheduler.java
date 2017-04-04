package edu.nyu.cs9053.homework8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LambdaWeightedScheduler {

    private final List<Job> jobs;

    public LambdaWeightedScheduler(Collection<Job> jobs) {
        this.jobs = new ArrayList<>(jobs);
    }

    public List<Job> scheduleJobs() {

        AscJobFinishTimeComparator comparator = new AscJobFinishTimeComparator();
        Collections.sort(jobs, comparator);

        //Insert an item to make more convenient to record prevJob.
        jobs.add(0,new Job(0, -1, 0, 0));
        //Keep the maximum number j for job i which i and j are contained.
        int[] prevJob = new int[jobs.size()];
        for (int i = 1; i < jobs.size(); i++) {
            for(int j = i - 1; j >= 1; j--) {
                if(jobs.get(i).getStartTime() >= jobs.get(j).getFinishTime()) {
                    prevJob[i] = j;
                    break;
                }
                prevJob[i] = 0;
            }
        }

        //dynamic programming
        //result(i) = max(vi + result(p(i)), result(i-1)
        int[] result = new int[jobs.size()];
        result[0] = 0;

        //to record these jobs which are selected
        List<List<Job>> scheduledJobs = new ArrayList<>();
        scheduledJobs.add(new ArrayList<>());

        for (int i = 1; i < jobs.size(); i++) {

            result[i] = Math.max((jobs.get(i).getWeight() + result[prevJob[i]]),
                    result[i-1]);

            //record jobs
            List<Job> scheduledJobsStep;
            if((jobs.get(i).getWeight() + result[prevJob[i]]) > result[i-1]) {
                scheduledJobsStep = new ArrayList<>(scheduledJobs.get(prevJob[i]));
                scheduledJobsStep.add(jobs.get(i));
            } else {
                scheduledJobsStep = new ArrayList<>(scheduledJobs.get(i-1));
            }
            scheduledJobs.add(scheduledJobsStep);

        }
        return scheduledJobs.get(jobs.size()-1);
    }
}
