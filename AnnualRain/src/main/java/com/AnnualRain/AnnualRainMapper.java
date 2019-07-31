package com.AnnualRain;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AnnualRainMapper extends Mapper<LongWritable,Text,Text,FloatWritable>{
	
	protected void map(LongWritable in,Text l,Context con) throws NumberFormatException, IOException, InterruptedException{
		String key=l.toString().split("\\|")[0];
		String val=l.toString().split("\\|")[14];
		con.write(new Text(key),new FloatWritable(Float.parseFloat(val)));
	}

}
