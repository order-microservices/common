package com.kasyan.common.event;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Serdeable
public class CourierAssignedEvent extends GeneralOrderEvent {

  private String courierId;

  public CourierAssignedEvent(final String id, final String courierId) {
    super(EventType.COURIER_ASSIGNED, id);
    this.courierId = courierId;
  }
}
