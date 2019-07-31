package wordcount1.artifact;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class WordCountMain {
public static void main(String[] args) throws Exception{
	Configuration config = new Configuration();
	//Job  j= new Job();
	Job j= Job.getInstance(config, "wordcount");
	j.setJarByClass(WordCountMain.class);
	 FileInputFormat.addInputPath(j, new Path(args[0]));
	 FileOutputFormat.setOutputPath(j, new Path(args[1]));
	 j.setMapperClass(WordCountMapper.class);
	 j.setReducerClass(WordCountReducer.class);
	 j.setInputFormatClass(TextInputFormat.class);
	 j.setOutputFormatClass(TextOutputFormat.class);
	 j.setMapOutputKeyClass(Text.class);
	 j.setMapOutputValueClass(IntWritable.class);
	 j.setOutputKeyClass(Text.class);
	 j.setOutputValueClass(IntWritable.class);
	 //System.out.print("hi");
	 System.exit(j.waitForCompletion(true)?0:1);
}
}
