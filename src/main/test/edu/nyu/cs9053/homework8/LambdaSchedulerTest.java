package edu.nyu.cs9053.homework8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guomengqi on 4/3/17.
 */
class LambdaSchedulerTest {
    @Test
    void scheduleJobs() {
        List<Job> list = new ArrayList<>();
        list.add(new Job(1,0,2));
        list.add(new Job(2,3,4));
        list.add(new Job(2,0,5));
        list.add(new Job(2,2,3));
        System.out.println(LambdaScheduler.scheduleJobs(list).size());

    }

    @Test
    void weightedScheduler() {
        List<WeightJob> list = new ArrayList<>();
        list.add(new WeightJob(1,0,2, 2));
        list.add(new WeightJob(2,0,2, 4));
        list.add(new WeightJob(3,3,5, 4));
        list.add(new WeightJob(4,1,6, 9));
        for (WeightJob j: LambdaWeightedScheduler.scheduleJobs(list)) {
            System.out.println(j.getLabel()+":"+j.getWeight());
        }


    }

}