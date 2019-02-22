package edu.zju.cst.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSFileIfExists {
    public static void main(String[] args){
        try{
            String fileName = "test";
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS", "hdfs://localhost:9000");
            conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
            FileSystem fs = FileSystem.get(conf);
            if(fs.exists(new Path(fileName))){
                System.out.println("Exists");
            }else{
                System.out.println("Not Exists");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}