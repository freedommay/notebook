package com.example.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCountRunner {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        String[] otherArgs = new String[] {"hdfs://localhost:9000/wordcount/input", "hdfs://localhost:9000/wordcount/output"};
        Job wcjob = Job.getInstance(configuration);
        wcjob.setJarByClass(WordCountRunner.class);
        wcjob.setMapperClass(WordCountMapper.class);
        wcjob.setReducerClass(WordCountReducer.class);
        wcjob.setMapOutputKeyClass(Text.class);
        wcjob.setMapOutputValueClass(IntWritable.class);
        wcjob.setOutputKeyClass(Text.class);
        wcjob.setOutputValueClass(IntWritable.class);
        FileInputFormat.setInputPaths(wcjob, new Path(otherArgs[0]));
        FileOutputFormat.setOutputPath(wcjob, new Path(otherArgs[1]));
        boolean res = wcjob.waitForCompletion(true);
        System.exit(res?0:1);
    }
}
