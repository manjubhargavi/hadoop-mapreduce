package wordcount1.artifact;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text,IntWritable,Text,IntWritable>{
	public void reduce(Text key,Iterable<IntWritable> Values,Context con) throws IOException, InterruptedException{
		 Text word = new Text();
		 int count=0;
		 for(IntWritable val:Values){
			 
			 count+= val.get();
		 }word.set(key);
		 con.write(word, new IntWritable(count));
	}

}
