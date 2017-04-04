package edu.nyu.cs9053.homework8;

import java.util.Comparator;

class AscJobFinishTimeComparator implements Comparator<Job> {

    @Override
    public int compare(Job j1, Job j2) {
        return j1.getFinishTime() - j2.getFinishTime();
    }
        
}