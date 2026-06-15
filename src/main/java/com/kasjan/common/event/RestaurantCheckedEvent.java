package com.kasjan.common.event;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Serdeable
@NoArgsConstructor
public class RestaurantCheckedEvent extends GeneralOrderEvent {

  private String restaurantId;

  public RestaurantCheckedEvent(String orderId, final String restaurantId) {
    super(EventType.RESTAURANT_AVAILABILITY_CHECKED, orderId);
    this.restaurantId = restaurantId;
  }
}
