package com.Education;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class EducationMapper extends Mapper<LongWritable,Text,Text,Text>{
	public void map(LongWritable key,Text val,Context con) throws IOException, InterruptedException{
		
		//System.out.println(v);
		String k=val.toString().split("\\,")[0];
		String value = val.toString().split("\\,")[1];
		
		con.write(new Text(k), new Text(value));
		
	}
	

}
