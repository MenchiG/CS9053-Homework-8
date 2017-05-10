package edu.nyu.cs9053.homework8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LambdaWeightedScheduler {

    public static List<WeightJob> scheduleJobs(List<WeightJob> jobs) {

        if ((jobs == null) || jobs.isEmpty() || jobs.contains(null)) {
            throw new IllegalArgumentException();
        }

        List<WeightJob> needScheduleJobs = new ArrayList<>(jobs);
        AscJobFinishTimeComparator comparator = new AscJobFinishTimeComparator();
        Collections.sort(needScheduleJobs, comparator);

        //Insert an item to make more convenient to record prevJob.
        needScheduleJobs.add(0,new WeightJob(0, -1, 0, 0));
        //Keep the maximum number j for job i which i and j are contained.
        int[] prevJob = new int[needScheduleJobs.size()];
        for (int i = 1; i < needScheduleJobs.size(); i++) {
            for(int j = i - 1; j >= 1; j--) {
                if(needScheduleJobs.get(i).getStartTime() >= needScheduleJobs.get(j).getFinishTime()) {
                    prevJob[i] = j;
                    break;
                }
                prevJob[i] = 0;
            }
        }

        //dynamic programming
        //result(i) = max(vi + result(p(i)), result(i-1)
        int[] result = new int[needScheduleJobs.size()];
        result[0] = 0;

        //to record these jobs which are selected
        List<List<WeightJob>> scheduledJobs = new ArrayList<>();
        scheduledJobs.add(new ArrayList<>());

        for (int i = 1; i < jobs.size(); i++) {

            result[i] = Math.max((needScheduleJobs.get(i).getWeight() + result[prevJob[i]]),
                    result[i-1]);

            //record jobs
            List<WeightJob> scheduledJobsStep;
            if((needScheduleJobs.get(i).getWeight() + result[prevJob[i]]) > result[i-1]) {
                scheduledJobsStep = new ArrayList<>(scheduledJobs.get(prevJob[i]));
                scheduledJobsStep.add(needScheduleJobs.get(i));
            } else {
                scheduledJobsStep = new ArrayList<>(scheduledJobs.get(i-1));
            }
            scheduledJobs.add(scheduledJobsStep);

        }
        return scheduledJobs.get(jobs.size()-1);
    }
}
