package com.KeyValueText;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class KeyValueTextMain {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
		Configuration conf =new Configuration();
		conf.set("mapreduce.input.keyvaluelinerecordreader.key.value.separator", ",");
		Job j=Job.getInstance(conf, "KeyValueText");
		j.setJarByClass(KeyValueTextMain.class);
		j.setMapperClass(KeyValueTextMapper.class);
		j.setNumReduceTasks(0);
		FileInputFormat.addInputPath(j, new Path(args[0]));
		FileOutputFormat.setOutputPath(j,new Path(args[1]));
		j.setOutputKeyClass(Text.class);
		j.setOutputValueClass(Text.class);
		j.setMapOutputKeyClass(Text.class);
		j.setMapOutputValueClass(Text.class);
		j.setInputFormatClass(KeyValueTextInputFormat.class);
		j.setOutputFormatClass(TextOutputFormat.class);
		System.exit(j.waitForCompletion(true)?0:1);
		
	}
}
