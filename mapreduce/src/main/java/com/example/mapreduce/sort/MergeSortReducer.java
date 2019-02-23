package com.example.mapreduce.sort;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MergeSortReducer extends Reducer<IntWritable , IntWritable, IntWritable, IntWritable> {

    private IntWritable line = new IntWritable(1);

    @Override
    protected void reduce(IntWritable key, Iterable<IntWritable> value, Context context) throws IOException, InterruptedException {
        for (IntWritable one: value) {
            context.write(line, key);
            line = new IntWritable(line.get() + 1);
        }
    }
}
