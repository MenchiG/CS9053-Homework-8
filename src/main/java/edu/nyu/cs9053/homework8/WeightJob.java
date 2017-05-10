package edu.nyu.cs9053.homework8;

/**
 * Created by guomengqi on 5/9/17.
 */
public class WeightJob extends Job {
    private final int weight;

    public WeightJob(int label, int startTime, int finishTime, int weight) {
        super(label, startTime, finishTime);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
