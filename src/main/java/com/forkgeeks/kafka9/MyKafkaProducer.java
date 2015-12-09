package com.forkgeeks.kafka9;
import java.util.*;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.KafkaProducer;
public class MyKafkaProducer
{
    public static void main( String[] args )
    {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        System.out.println("Hello");

        Producer<String, String> producer = new KafkaProducer(props);
        for(int i = 0; i < 20; i++)
            producer.send(new ProducerRecord<String, String>("test-topic", null, Integer.toString(i)));
        producer.close();
    }
}
