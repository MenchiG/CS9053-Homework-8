package edu.nyu.cs9053.homework8;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class JobTest {



    @Test
    void invalidJob() {

        assertThrows(InvalidParameterException.class, () -> {
            new Job(1, 8, 0);
        });
    }

    @Test
    void getters() {
        Job job = new Job(1, 0, 1);
        assertEquals(1, job.getLabel());
        assertEquals(0, job.getStartTime());
        assertEquals(1, job.getFinishTime());
    }


}