package com.kasjan.common.event;

import io.micronaut.serde.annotation.Serdeable;
import lombok.NoArgsConstructor;

@Serdeable
@NoArgsConstructor
public class OrderDeliveredEvent extends GeneralOrderEvent {
  public OrderDeliveredEvent(
      final String id,
      final String accountId,
      final String restaurantId,
      final String courierId,
      final double amount
  ) {
    super(EventType.ORDER_DELIVERED, id);
  }
}
