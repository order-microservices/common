package com.kasjan.common.event;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Serdeable
@NoArgsConstructor
public class CourierUnassignedEvent extends GeneralOrderEvent {

  private String courierId;

  public CourierUnassignedEvent(final String orderId, final String courierId) {
    super(EventType.COURIER_UNASSIGNED, orderId);
    this.courierId = courierId;
  }
}
