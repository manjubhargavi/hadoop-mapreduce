package com.TextToSequence;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;

public class TextToSquenceMain {
	public static void main(String args[]) throws IOException, ClassNotFoundException, InterruptedException{
		Configuration conf =new Configuration();
		Job j=Job.getInstance(conf, "TextToSquenceMain");
		j.setJarByClass(TextToSquenceMain.class);
		j.setMapperClass(TextToSequenceMapper.class);
		TextInputFormat.addInputPath(j,new Path(args[0]));
		SequenceFileOutputFormat.setOutputPath(j, new Path(args[1]));
		j.setMapOutputKeyClass(LongWritable.class);
		j.setMapOutputValueClass(Text.class);
		j.setNumReduceTasks(0);
		System.exit(j.waitForCompletion(true)?0:1);
	}

}
