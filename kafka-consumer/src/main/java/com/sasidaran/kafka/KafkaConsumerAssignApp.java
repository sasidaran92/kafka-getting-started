package com.sasidaran.kafka;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

public class KafkaConsumerAssignApp {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092,localhost:9093");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("group.id", "test");

		ArrayList<TopicPartition> topicPartitions = new ArrayList<>();
		TopicPartition topicPartition = new TopicPartition("my_topic_cluster_java", 1);
		topicPartitions.add(topicPartition);

		try (KafkaConsumer<String, String> myConsumer = new KafkaConsumer<>(props);) {
			myConsumer.assign(topicPartitions);
			while (true) {
				ConsumerRecords<String, String> records = myConsumer.poll(Duration.ofMillis(10));
				for (ConsumerRecord<String, String> record : records) {

					System.out.println(String.format("Topic: %s, Partition: %d, Offset: %d, Key:%s, Value: %s",
							record.topic(), record.partition(), record.offset(), record.key(), record.value()));
				}
			}
		} catch (Exception e) {
		}
	}

}
