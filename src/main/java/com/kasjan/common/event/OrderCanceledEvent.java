package com.kasjan.common.event;

import io.micronaut.serde.annotation.Serdeable;
import lombok.NoArgsConstructor;

@Serdeable
@NoArgsConstructor
public class OrderCanceledEvent extends GeneralOrderEvent {
  public OrderCanceledEvent(final String id) {
    super(EventType.ORDER_CANCELED, id);
  }
}
