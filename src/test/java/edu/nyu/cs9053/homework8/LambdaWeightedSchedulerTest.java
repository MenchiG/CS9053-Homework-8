package edu.nyu.cs9053.homework8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LambdaWeightedSchedulerTest {

    @Test
    void scheduleJobs() {
        List<WeightJob> list = new ArrayList<>();

        /*
        |Time   |0 |1  |2|3 |4 |5|6|
        |Job    |12|124|4|34|34|4|
        |Weight |24|249|9|49|49|9|

        ans:
        |Time   |0|1|2|3|4|5|6|
        |Job    |2|2|*|3|3|*|
        |Weight |4|4|*|4|4|*|
        */

        list.add(new WeightJob(1,0,2, 2));
        list.add(new WeightJob(2,0,2, 4));
        list.add(new WeightJob(3,3,5, 4));
        list.add(new WeightJob(4,1,6, 9));

        list = LambdaWeightedScheduler.scheduleJobs(list);

        assertEquals(2,list.size());
        assertEquals(2,list.get(0).getLabel());
        assertEquals(3,list.get(1).getLabel());

    }
}