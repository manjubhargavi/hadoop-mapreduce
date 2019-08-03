package com.KeyValueText;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class KeyValueTextMapper extends Mapper<Text,Text,Text ,Text> {
	public void map(Text key,Text val,Context con) throws IOException, InterruptedException{
		con.write(new Text(key), new Text(val));
	}

}
