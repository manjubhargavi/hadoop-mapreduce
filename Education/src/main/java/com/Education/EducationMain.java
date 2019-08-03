package com.Education;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;




public class EducationMain {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
		Configuration config =new Configuration();
		Job  j= Job.getInstance(config, "EducatioMain");
		FileInputFormat.addInputPath(j, new Path(args[0]));
		FileOutputFormat.setOutputPath(j,new Path(args[1]));
		j.setJarByClass(EducationMain.class);
		j.setMapperClass(EducationMapper.class);
		j.setReducerClass(EducationReducer.class);
		j.setInputFormatClass(TextInputFormat.class);
		j.setOutputFormatClass(TextOutputFormat.class);
		j.setOutputKeyClass(Text.class);
		j.setOutputValueClass(Text.class);
		j.setMapOutputKeyClass(Text.class);
		j.setPartitionerClass(MyPartitioner.class);
		j.setNumReduceTasks(2);
		j.setMapOutputValueClass(Text.class);
		System.exit(j.waitForCompletion(true)?0:1);
	}
}
