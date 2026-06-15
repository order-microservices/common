package com.kasjan.common.event;

import io.micronaut.serde.annotation.Serdeable;
import lombok.NoArgsConstructor;

@Serdeable
@NoArgsConstructor
public class OrderDeliveredEvent extends GeneralOrderEvent {
  public OrderDeliveredEvent(final String id) {
    super(EventType.ORDER_DELIVERED, id);
  }
}
