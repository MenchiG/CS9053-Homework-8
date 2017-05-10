package edu.nyu.cs9053.homework8;

import java.security.InvalidParameterException;

public class Job {

    private final int label;
    private final int startTime;
    private final int finishTime;


    public Job(int label, int startTime, int finishTime) {

        if(finishTime > startTime) {
            this.label = label;
            this.startTime = startTime;
            this.finishTime = finishTime;
        } else {
            throw new InvalidParameterException("Job's finish time must later than start time");
        }
    }

    public int getStartTime() {
        return startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public int getLabel() {
        return label;
    }

}