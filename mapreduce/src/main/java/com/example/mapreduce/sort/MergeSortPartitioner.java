package com.example.mapreduce.sort;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class MergeSortPartitioner extends Partitioner<LongWritable, IntWritable> {

    @Override
    public int getPartition(LongWritable key, IntWritable value, int num_partition) {
        int bound = Integer.MAX_VALUE / num_partition + 1;
        for (int i = 0; i < num_partition; i++) {
            if (key.get() < bound * i && key.get() >= bound * (i - 1)) {
                return i - 1;
            }
        }
        return -1;
    }
}
