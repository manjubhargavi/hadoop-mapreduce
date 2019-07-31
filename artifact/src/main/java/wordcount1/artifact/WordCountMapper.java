package wordcount1.artifact;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable ,Text,Text,IntWritable> {
	public void map(LongWritable key,Text Value,Context con) throws IOException, InterruptedException{
		IntWritable one =new IntWritable(1);
		 Text word =new Text();
		String val= Value.toString();
		String[] s= val.split(" ");
		for(String v : s){
			word.set(v);
			con.write(word, one);
		}
	}

}
