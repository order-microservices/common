package com.kasjan.common.kafka;

import com.kasjan.common.MdcConstants;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.MDC;

@Slf4j
public class XRayIdProducerInterceptor implements ProducerInterceptor<String, Object> {

  public XRayIdProducerInterceptor() {
    log.info("XRayIdProducerInterceptor initialized");
  }

  @Override
  public ProducerRecord<String, Object> onSend(final ProducerRecord<String, Object> producerRecord) {
    final var xRayId = MDC.get(MdcConstants.X_RAY_ID);
    if (xRayId == null) {
      throw new RuntimeException("XRayId is not set");
    }
    producerRecord.headers().add(MdcConstants.X_RAY_ID, xRayId.getBytes());
    return producerRecord;
  }

  @Override
  public void onAcknowledgement(final RecordMetadata recordMetadata, final Exception e) {

  }

  @Override
  public void close() {

  }

  @Override
  public void configure(final Map<String, ?> map) {

  }
}
