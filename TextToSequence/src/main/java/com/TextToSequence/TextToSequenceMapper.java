package com.TextToSequence;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TextToSequenceMapper extends Mapper<LongWritable,Text,LongWritable,Text> {
public void map(LongWritable key,Text val,Context con) throws IOException, InterruptedException{
	con.write(key, val);
}
}
