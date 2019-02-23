package com.example.mapreduce.md;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

// 文件的合并和去重
public class MergeAndDeduplicateRunner  {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        String[] otherArgs = new String[] {"hdfs://localhost:9000/user/hadoop/md/input/", "hdfs://localhost:9000/user/hadoop/md/output"};
        Job wcjob = Job.getInstance(configuration);
        wcjob.setJarByClass(MergeAndDeduplicateRunner.class);
        wcjob.setMapperClass(MergeAndDeduplicateMapper.class);
        wcjob.setReducerClass(MergeAndDeduplicateReducer.class);
        wcjob.setMapOutputKeyClass(Text.class);
        wcjob.setMapOutputValueClass(Text.class);
        wcjob.setOutputKeyClass(Text.class);
        wcjob.setOutputValueClass(Text.class);
        FileInputFormat.setInputPaths(wcjob, new Path(otherArgs[0]));
        FileOutputFormat.setOutputPath(wcjob, new Path(otherArgs[1]));
        boolean res = wcjob.waitForCompletion(true);
        System.exit(res?0:1);
    }
}
