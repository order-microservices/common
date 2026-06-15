package com.kasjan.common.event;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Serdeable
@NoArgsConstructor
public class CourierTookOrderEvent extends GeneralOrderEvent {

  private String courierId;

  public CourierTookOrderEvent(final String orderId, final String courierId) {
    super(EventType.COURIER_TOOK_ORDER, orderId);
    this.courierId = courierId;
  }
}
