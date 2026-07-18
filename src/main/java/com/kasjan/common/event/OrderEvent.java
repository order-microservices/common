package com.kasjan.common.event;

import io.micronaut.serde.annotation.Serdeable;
import java.time.Instant;
import java.util.UUID;
import lombok.Data;

@Data
@Serdeable
public class OrderEvent {
  private String eventId;
  private EventType type;
  private String orderId;
  private String accountId;
  private Double amount;
  private String restaurantId;
  private String courierId;
  private Instant createdAt;
  private String errorMessage;
  private Instant deliveredAt;
  private String xRayId;

  public static OrderEvent orderCreated(final String eventId, String orderId, final String accountId, final Instant createdAt) {
    final var event = new OrderEvent();
    event.setEventId(eventId);
    event.setType(EventType.ORDER_CREATED);
    event.setOrderId(orderId);
    event.setAccountId(accountId);
    event.setCreatedAt(createdAt);
    return event;
  }

  public static OrderEvent paymentAuthorized(final String orderId, final String accountId) {
    final var event = new OrderEvent();
    event.setEventId(UUID.randomUUID().toString());
    event.setType(EventType.PAYMENT_AUTHORIZED);
    event.setOrderId(orderId);
    event.setAccountId(accountId);
    return event;
  }

  public static OrderEvent paymentAuthorizationFailed(final String orderId, final String accountId, final String errorMessage) {
    final var event = new OrderEvent();
    event.setEventId(UUID.randomUUID().toString());
    event.setType(EventType.PAYMENT_VALIDATION_FAILED);
    event.setOrderId(orderId);
    event.setAccountId(accountId);
    event.setErrorMessage(errorMessage);
    return event;
  }

  public static OrderEvent paymentVoided(
      final String orderId,
      final String accountId,
      final Double amount
  ) {
    final var event = new OrderEvent();
    event.setEventId(UUID.randomUUID().toString());
    event.setType(EventType.PAYMENT_VOIDED);
    event.setOrderId(orderId);
    event.setAccountId(accountId);
    event.setAmount(amount);

    return event;
  }

  public static OrderEvent restaurantConfirmed(final String orderId, final String restaurantId, final String accountId) {
    final var event = new OrderEvent();
    event.setEventId(UUID.randomUUID().toString());
    event.setType(EventType.RESTAURANT_AVAILABILITY_CHECKED);
    event.setOrderId(orderId);
    event.setRestaurantId(restaurantId);
    event.setAccountId(accountId);

    return event;
  }

  public static OrderEvent orderDelivered(
      final String orderId,
      final String accountId,
      final String restaurantId,
      final String courierId,
      final double amount
  ) {
    final var event = new OrderEvent();
    event.setEventId(UUID.randomUUID().toString());
    event.setType(EventType.ORDER_DELIVERED);
    event.setOrderId(orderId);
    event.setAccountId(accountId);
    event.setRestaurantId(restaurantId);
    event.setCourierId(courierId);
    event.setAmount(amount);
    event.setDeliveredAt(Instant.now());

    return event;
  }

  public static OrderEvent orderCancelRequested(final String eventId, final String orderId, final String accountId) {
    final var event = new OrderEvent();
    event.setEventId(eventId);
    event.setType(EventType.ORDER_CANCEL_REQUESTED);
    event.setAccountId(accountId);
    event.setOrderId(orderId);

    return event;
  }

  public static OrderEvent orderCanceled(final String orderId, final String accountId, final double amount) {
    final var event = new OrderEvent();
    event.setEventId(UUID.randomUUID().toString());
    event.setType(EventType.ORDER_CANCELED);
    event.setAccountId(accountId);
    event.setAmount(amount);
    event.setOrderId(orderId);

    return event;
  }

  public static OrderEvent manualReviewRequested(final String orderId, final String accountId, final String xRayId) {
    final var event = new OrderEvent();
    event.setEventId(UUID.randomUUID().toString());
    event.setType(EventType.MANUAL_REVIEW_REQUESTED);
    event.setAccountId(accountId);
    event.setOrderId(orderId);
    event.setXRayId(xRayId);

    return event;
  }

  public OrderEvent withXRayId(final String xRayId) {
    this.xRayId = xRayId;
    return this;
  }
}
