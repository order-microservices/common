package com.kasjan.common.event;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Serdeable
@NoArgsConstructor
public class CourierAssignedEvent extends GeneralOrderEvent {

  private String courierId;

  public CourierAssignedEvent(final String id, final String courierId) {
    super(EventType.COURIER_ASSIGNED, id);
    this.courierId = courierId;
  }
}
