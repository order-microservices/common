package com.kasjan.common.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kasjan.common.model.Location;
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
  private String errorMessage;
  private Instant deliveredAt;
  @JsonProperty("xRayId")
  private String xRayId;
  private Instant eventTime;
  private Instant orderCreatedAt;
  private Location pickupLocation;
  private Location dropoffLocation;
  private Double distanceToPickup;
  private Double distanceToDropOff;
  private String offerId;

  public static OrderEvent orderCreated(
      final String eventId,
      String orderId,
      final String accountId,
      final Instant eventTime,
      final Instant orderCreatedAt
  ) {
    final var event = new OrderEvent();
    event.setEventId(eventId);
    event.setType(EventType.ORDER_CREATED);
    event.setOrderId(orderId);
    event.setAccountId(accountId);
    event.setEventTime(eventTime);
    event.setOrderCreatedAt(orderCreatedAt);

    return event;
  }

  public static OrderEvent paymentAuthorized(final String orderId, final String accountId, final Instant eventTime, final Instant orderCreatedAt) {
    final var event = new OrderEvent();
    event.setEventId(UUID.randomUUID().toString());
    event.setType(EventType.PAYMENT_AUTHORIZED);
    event.setOrderId(orderId);
    event.setAccountId(accountId);
    event.setEventTime(eventTime);
    event.setOrderCreatedAt(orderCreatedAt);

    return event;
  }

  public static OrderEvent paymentAuthorizationFailed(
      final String orderId,
      final String accountId,
      final String errorMessage,
      final Instant eventTime,
      final Instant orderCreatedAt
  ) {
    final var event = new OrderEvent();
    event.setEventId(UUID.randomUUID().toString());
    event.setType(EventType.PAYMENT_VALIDATION_FAILED);
    event.setOrderId(orderId);
    event.setAccountId(accountId);
    event.setErrorMessage(errorMessage);
    event.setEventTime(eventTime);
    event.setOrderCreatedAt(orderCreatedAt);

    return event;
  }

  public static OrderEvent paymentVoided(
      final String orderId,
      final String accountId,
      final Double amount,
      final Instant eventTime,
      final Instant orderCreatedAt
  ) {
    final var event = new OrderEvent();
    event.setEventId(UUID.randomUUID().toString());
    event.setType(EventType.PAYMENT_VOIDED);
    event.setOrderId(orderId);
    event.setAccountId(accountId);
    event.setAmount(amount);
    event.setEventTime(eventTime);
    event.setOrderCreatedAt(orderCreatedAt);

    return event;
  }

  public static OrderEvent restaurantConfirmed(
      final String orderId,
      final String restaurantId,
      final String accountId,
      final Instant eventTime,
      final Instant orderCreatedAt
  ) {
    final var event = new OrderEvent();
    event.setEventId(UUID.randomUUID().toString());
    event.setType(EventType.RESTAURANT_AVAILABILITY_CHECKED);
    event.setOrderId(orderId);
    event.setRestaurantId(restaurantId);
    event.setAccountId(accountId);
    event.setEventTime(eventTime);
    event.setOrderCreatedAt(orderCreatedAt);

    return event;
  }

  public static OrderEvent orderDelivered(
      final String orderId,
      final String courierId,
      final String offerId,
      final String accountId,
      final String xRayId,
      final Instant deliveredAt,
      final Instant eventTime,
      final Instant orderCreatedAt
  ) {
    final var type = EventType.ORDER_DELIVERED;
    final var event = new OrderEvent();
    event.setEventId(type.eventId(orderId, courierId, offerId));
    event.setType(type);
    event.setOrderId(orderId);
    event.setCourierId(courierId);
    event.setOfferId(offerId);
    event.setAccountId(accountId);
    event.setXRayId(xRayId);
    event.setDeliveredAt(deliveredAt);
    event.setEventTime(eventTime);
    event.setOrderCreatedAt(orderCreatedAt);

    return event;
  }

  public static OrderEvent orderCancelRequested(
      final String eventId,
      final String orderId,
      final String accountId,
      final Instant eventTime,
      final Instant orderCreatedAt
  ) {
    final var event = new OrderEvent();
    event.setEventId(eventId);
    event.setType(EventType.ORDER_CANCEL_REQUESTED);
    event.setAccountId(accountId);
    event.setOrderId(orderId);
    event.setEventTime(eventTime);
    event.setOrderCreatedAt(orderCreatedAt);

    return event;
  }

  public static OrderEvent orderCanceled(
      final String orderId,
      final String accountId,
      final double amount,
      final Instant eventTime,
      final Instant orderCreatedAt
  ) {
    final var event = new OrderEvent();
    event.setEventId(UUID.randomUUID().toString());
    event.setType(EventType.ORDER_CANCELED);
    event.setAccountId(accountId);
    event.setAmount(amount);
    event.setOrderId(orderId);
    event.setEventTime(eventTime);
    event.setOrderCreatedAt(orderCreatedAt);

    return event;
  }

  public static OrderEvent manualReviewRequested(
      final String orderId,
      final String accountId,
      final String xRayId,
      final Instant eventTime,
      final Instant orderCreatedAt
  ) {
    final var event = new OrderEvent();
    event.setEventId(UUID.randomUUID().toString());
    event.setType(EventType.MANUAL_REVIEW_REQUESTED);
    event.setAccountId(accountId);
    event.setOrderId(orderId);
    event.setXRayId(xRayId);
    event.setEventTime(eventTime);
    event.setOrderCreatedAt(orderCreatedAt);

    return event;
  }

  public static OrderEvent courierPickedUpOrder(
      final String orderId,
      final String courierId,
      final String offerId,
      final String accountId,
      final String xRayId,
      final Instant eventTime,
      final Instant orderCreatedAt
  ) {
    final var type = EventType.COURIER_PICKED_UP_ORDER;
    final var event = new OrderEvent();
    event.setEventId(type.eventId(orderId, courierId));
    event.setOfferId(offerId);
    event.setType(type);
    event.setOrderId(orderId);
    event.setCourierId(courierId);
    event.setAccountId(accountId);
    event.setXRayId(xRayId);
    event.setEventTime(eventTime);
    event.setOrderCreatedAt(orderCreatedAt);

    return event;
  }

  public static OrderEvent orderOfferedForCourier(
      final String eventId,
      final String orderId,
      final String offerId,
      final String courierId,
      final String accountId,
      final Location pickupLocation,
      final Location dropoffLocation,
      final double distanceToPickup,
      final double distanceToDropOff,
      final String xRayId,
      final Instant eventTime,
      final Instant orderCreatedAt
  ) {
    final var event = new OrderEvent();
    event.setEventId(eventId);
    event.setType(EventType.ORDER_OFFERED_TO_COURIER);
    event.setOrderId(orderId);
    event.setCourierId(courierId);
    event.setAccountId(accountId);
    event.setPickupLocation(pickupLocation);
    event.setDropoffLocation(dropoffLocation);
    event.setDistanceToPickup(distanceToPickup);
    event.setDistanceToDropOff(distanceToDropOff);
    event.setEventTime(eventTime);
    event.setOfferId(offerId);
    event.setXRayId(xRayId);
    event.setOrderCreatedAt(orderCreatedAt);

    return event;
  }

  public static OrderEvent courierAcceptedOffer(
      final String orderId,
      final String offerId,
      final String courierId,
      final String accountId,
      final String xRayId,
      final Instant eventTime,
      final Instant orderCreatedAt
  ) {
    final var type = EventType.COURIER_ACCEPTED_OFFER;
    final var id = type.eventId(offerId);
    final var event = new OrderEvent();
    event.setEventId(id);
    event.setOfferId(offerId);
    event.setOrderId(orderId);
    event.setCourierId(courierId);
    event.setAccountId(accountId);
    event.setType(type);
    event.setXRayId(xRayId);
    event.setEventTime(eventTime);
    event.setOrderCreatedAt(orderCreatedAt);

    return event;
  }

  public static OrderEvent courierUnassigned(
      final String orderId,
      final String courierId,
      final String accountId,
      final String xRayId,
      final Instant eventTime,
      final Instant orderCreatedAt
  ) {
    final var type = EventType.COURIER_UNASSIGNED;
    final var id = type.eventId(orderId, courierId);
    final var event = new OrderEvent();
    event.setEventId(id);
    event.setOrderId(orderId);
    event.setCourierId(courierId);
    event.setAccountId(accountId);
    event.setType(type);
    event.setXRayId(xRayId);
    event.setEventTime(eventTime);
    event.setOrderCreatedAt(orderCreatedAt);

    return event;
  }

  public static OrderEvent offerExpired(
      final String orderId,
      final String offerId,
      final String courierId,
      final String xRayId,
      final Instant eventTime,
      final Instant orderCreatedAt
  ) {
    final var type = EventType.OFFER_EXPIRED;
    final var id = type.eventId(offerId);
    final var event = new OrderEvent();
    event.setEventId(id);
    event.setOfferId(offerId);
    event.setOrderId(orderId);
    event.setType(type);
    event.setXRayId(xRayId);
    event.setCourierId(courierId);
    event.setEventTime(eventTime);
    event.setOrderCreatedAt(orderCreatedAt);

    return event;
  }

  public OrderEvent withXRayId(final String xRayId) {
    this.xRayId = xRayId;
    return this;
  }
}
