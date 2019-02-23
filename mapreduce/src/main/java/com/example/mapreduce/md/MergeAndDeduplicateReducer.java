package com.example.mapreduce.md;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MergeAndDeduplicateReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> value, Context Context)
        throws IOException, InterruptedException {
        Context.write(key, new Text());
    }
}
