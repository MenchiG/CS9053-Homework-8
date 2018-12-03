package edu.nyu.cs9053.homework8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by guomengqi on 5/29/17.
 */
class LambdaSchedulerTest {
    @Test
    void scheduleJobs() {
        List<Job> list = new ArrayList<>();

        /*
        |Time|0 |1 |2 |3 |4|5|
        |Job |13|13|34|23|3|

        ans:
        |Time|0|1|2|3|4|5|
        |Job |1|1|4|2|
         */

        list.add(new Job(1,0,2));
        list.add(new Job(2,3,4));
        list.add(new Job(3,0,5));
        list.add(new Job(4,2,3));

        list = LambdaScheduler.scheduleJobs(list);

        assertEquals(3,list.size());
        assertEquals(1,list.get(0).getLabel());
        assertEquals(4,list.get(1).getLabel());
        assertEquals(2,list.get(2).getLabel());

    }

}