package com.kasjan.common.event;

import io.micronaut.serde.annotation.Serdeable;
import java.time.Instant;
import lombok.Data;

@Data
@Serdeable
public class OrderEvent {
  private EventType type;
  private String id;
  private String accountId;
  private Double amount;
  private String restaurantId;
  private String courierId;
  private Instant createdAt;
  private String errorMessage;
  private Instant deliveredAt;

  public static OrderEvent orderCreated(final String id, final String accountId, final Instant createdAt) {
    final var event = new OrderEvent();
    event.setType(EventType.ORDER_CREATED);
    event.setId(id);
    event.setAccountId(accountId);
    event.setCreatedAt(createdAt);
    return event;
  }

  public static OrderEvent paymentAuthorized(final String id, final String accountId) {
    final var event = new OrderEvent();
    event.setType(EventType.PAYMENT_AUTHORIZED);
    event.setId(id);
    event.setAccountId(accountId);
    return event;
  }

  public static OrderEvent paymentAuthorizationFailed(final String id, final String accountId, final String errorMessage) {
    final var event = new OrderEvent();
    event.setType(EventType.PAYMENT_VALIDATION_FAILED);
    event.setId(id);
    event.setAccountId(accountId);
    event.setErrorMessage(errorMessage);
    return event;
  }

  public static OrderEvent paymentVoided(
      final String id,
      final String accountId,
      final Double amount
  ) {
    final var event = new OrderEvent();
    event.setType(EventType.PAYMENT_VOIDED);
    event.setId(id);
    event.setAccountId(accountId);
    event.setAmount(amount);

    return event;
  }

  public static OrderEvent restaurantConfirmed(final String id, final String restaurantId, final String accountId) {
    final var event = new OrderEvent();
    event.setType(EventType.RESTAURANT_AVAILABILITY_CHECKED);
    event.setId(id);
    event.setRestaurantId(restaurantId);
    event.setAccountId(accountId);

    return event;
  }

  public static OrderEvent orderDelivered(
      final String id,
      final String accountId,
      final String restaurantId,
      final String courierId,
      final double amount
  ) {
    final var event = new OrderEvent();
    event.setType(EventType.ORDER_DELIVERED);
    event.setId(id);
    event.setAccountId(accountId);
    event.setRestaurantId(restaurantId);
    event.setCourierId(courierId);
    event.setAmount(amount);
    event.setDeliveredAt(Instant.now());

    return event;
  }

  public static OrderEvent orderCanceled(final String id, final String accountId, final double amount) {
    final var event = new OrderEvent();
    event.setType(EventType.ORDER_CANCELED);
    event.setAccountId(accountId);
    event.setAmount(amount);
    event.setId(id);

    return event;
  }
}
