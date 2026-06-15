package com.kasjan.common.event;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Serdeable
@NoArgsConstructor
public class RestaurantCheckFailedEvent extends GeneralOrderEvent {

  private String restaurantId;
  private String reason;

  public RestaurantCheckFailedEvent(final String id, final String restaurantId, final String reason) {
    super(EventType.RESTAURANT_AVAILABILITY_CHECK_FAILED, id);
    this.restaurantId = restaurantId;
    this.reason = reason;
  }
}
