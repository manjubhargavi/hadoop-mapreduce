package com.AnnualRain;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class AnnualRainMain {

	public static void main(String[] args) throws IllegalArgumentException, IOException,Exception{
		// TODO Auto-generated method stub
		Configuration config =new Configuration();
		Job  j= Job.getInstance(config, "MaxAnnualRainFall");
		FileInputFormat.addInputPath(j, new Path(args[0]));
		FileOutputFormat.setOutputPath(j,new Path(args[1]));
		j.setJarByClass(AnnualRainMain.class);
		j.setMapperClass(com.AnnualRain.AnnualRainMapper.class);
		j.setReducerClass(com.AnnualRain.AnnualRainReducer.class);
		j.setInputFormatClass(TextInputFormat.class);
		j.setOutputFormatClass(TextOutputFormat.class);
		j.setOutputKeyClass(Text.class);
		j.setOutputValueClass(FloatWritable.class);
		j.setMapOutputKeyClass(Text.class);
		j.setMapOutputValueClass(FloatWritable.class);
		System.exit(j.waitForCompletion(true)?0:1);
		
	}

}
