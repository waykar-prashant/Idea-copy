package org.idea.streaming.example;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Pattern;

import scala.Tuple2;

import com.google.common.collect.Lists;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
//import org.apache.spark.examples.streaming.StreamingExamples;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaPairReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;

public final class KafkaWordCount {
	private static final Pattern SPACE = Pattern.compile(" ");

	private KafkaWordCount() {
	}

	public static void main(String[] argsold) {
		
//		String kafkaIP = "localhost:9092";
//		String sparkIP = "spark://Surbhis-MacBook-Pro.local:7077";
//		String topic = "test1";
		
		String zkHosts = "localhost";
		String listenTopics = "test1";
		String listenerName = "testListener";

		SparkConf sparkConf = new SparkConf().setAppName("JavaWordCount")
				.setMaster("local[2]").set("spark.executor.memory", "1g"); 
		JavaStreamingContext jssc = new JavaStreamingContext(sparkConf,
				new Duration(20000));
		
		// Setting the spark executor memory and local[2] are very important to avoid the following error:
		/*Initial job has not accepted any resources; check your cluster UI 
		 * to ensure that workers are registered and have sufficient resources
		 * */
		
		int numThreads = 5;
		Map<String, Integer> topicMap = new HashMap<String, Integer>();

		String[] topics = listenTopics.split(",");
		for (String topic : topics) {
			topicMap.put(topic, numThreads);
		}

		JavaPairReceiverInputDStream<String, String> messages = KafkaUtils.createStream(jssc, zkHosts, listenerName, topicMap);

		JavaDStream<String> lines = messages
				.map(new Function<Tuple2<String, String>, String>() {
					@Override
					public String call(Tuple2<String, String> tuple2) {
						return tuple2._2();
					}
				});

		JavaDStream<String> words = lines
				.flatMap(new FlatMapFunction<String, String>() {
					@Override
					public Iterable<String> call(String x) {
						return Lists.newArrayList(SPACE.split(x));
					}
				});

		JavaPairDStream<String, Integer> wordCounts = words.mapToPair(
				new PairFunction<String, String, Integer>() {
					@Override
					public Tuple2<String, Integer> call(String s) {
						return new Tuple2<String, Integer>(s, 1);
					}
				}).reduceByKey(new Function2<Integer, Integer, Integer>() {
			@Override
			public Integer call(Integer i1, Integer i2) {
				return i1 + i2;
			}
		});
		System.out.print("Printing the word count....." + wordCounts.toString());
		wordCounts.print();
		jssc.start();
		jssc.awaitTermination();
	}
}