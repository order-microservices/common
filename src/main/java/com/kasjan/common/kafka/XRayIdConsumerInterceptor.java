package com.kasjan.common.kafka;

import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

public class XRayIdConsumerInterceptor implements ConsumerInterceptor<String, Object> {

  @Override
  public ConsumerRecords<String, Object> onConsume(final ConsumerRecords<String, Object> consumerRecords) {
    return consumerRecords;
  }

  @Override
  public void onCommit(final Map<TopicPartition, OffsetAndMetadata> map) {

  }

  @Override
  public void close() {

  }

  @Override
  public void configure(final Map<String, ?> map) {

  }
}
