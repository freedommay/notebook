package edu.zju.cst.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HDFSFileReader {
    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration();
            FileSystem fs = FileSystem.get(conf);
            Path filename = new Path("hdfs://localhost:9000/user/hadoop/test.txt");
            FSDataInputStream is = fs.open(filename);
            BufferedReader d = new BufferedReader(new InputStreamReader(is));
            String content = d.readLine();
            System.out.println(content);
            d.close();
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
