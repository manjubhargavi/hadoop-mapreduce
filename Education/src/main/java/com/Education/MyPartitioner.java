package com.Education;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyPartitioner extends Partitioner<Text, Text>{
	

	@Override
	public int getPartition(Text key, Text val, int arg2) {
		// TODO Auto-generated method stub
		String k=key.toString().toUpperCase();
		if(k.equals("SECONDARY SCHOOL")){
			return 0;
		}
		else{
			return 1;
		}
	}

	
	

}
