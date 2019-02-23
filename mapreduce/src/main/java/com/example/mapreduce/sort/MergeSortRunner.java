package com.example.mapreduce.sort;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

// 对输入文件进行排序
public class MergeSortRunner {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        String[] otherArgs = new String[] {"hdfs://localhost:9000/user/hadoop/sort/input/", "hdfs://localhost:9000/user/hadoop/sort/output"};
        Job wcjob = Job.getInstance(configuration);
        wcjob.setJarByClass(MergeSortRunner.class);
        wcjob.setMapperClass(MergeSortMapper.class);
        wcjob.setReducerClass(MergeSortReducer.class);
        wcjob.setPartitionerClass(MergeSortPartitioner.class);
        wcjob.setMapOutputKeyClass(IntWritable.class);
        wcjob.setMapOutputValueClass(IntWritable.class);
        wcjob.setOutputKeyClass(IntWritable.class);
        wcjob.setOutputValueClass(IntWritable.class);
        FileInputFormat.setInputPaths(wcjob, new Path(otherArgs[0]));
        FileOutputFormat.setOutputPath(wcjob, new Path(otherArgs[1]));
        boolean res = wcjob.waitForCompletion(true);
        System.exit(res?0:1);
    }
}
