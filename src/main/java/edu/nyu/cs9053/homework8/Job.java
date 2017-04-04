package edu.nyu.cs9053.homework8;

import java.security.InvalidParameterException;

public class Job {

    private final int label;
    private final int startTime;
    private final int finishTime;
    private final int weight;

    public Job(int label, int startTime, int finishTime, int weight) {

        if(finishTime > startTime) {
            this.label = label;
            this.startTime = startTime;
            this.finishTime = finishTime;
            this.weight = weight;
        } else {
            throw new InvalidParameterException("Job's finish time must later than start time");
        }
    }

    public Job(int label, int startTime, int finishTime) {
        this(label, startTime, finishTime, 0);
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

    public int getWeight() {
        return weight;
    }
}