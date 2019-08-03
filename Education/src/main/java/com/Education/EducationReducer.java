package com.Education;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class EducationReducer extends Reducer<Text,Text,Text,Text> {
public void reduce(Text key,Iterator<Text> val,Context con) throws IOException, InterruptedException{
	while(val.hasNext()){
		con.write(new Text(key), new Text(val.next().toString()));
	}
	
}
}
