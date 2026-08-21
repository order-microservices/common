package com.kasjan.common.event;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public enum EventType {
  ACCOUNT_CREATED,

  ORDER_CREATED,

  PAYMENT_AUTHORIZED,
  PAYMENT_VALIDATION_FAILED,
  PAYMENT_VOIDED,

  RESTAURANT_AVAILABILITY_CHECKED,
  RESTAURANT_AVAILABILITY_CHECK_FAILED,

  COURIER_ACCEPTED_OFFER,
  ORDER_OFFERED_TO_COURIER,
  COURIER_UNASSIGNED,
  COURIER_PICKED_UP_ORDER,
  OFFER_EXPIRED,

  ORDER_DELIVERED,
  ORDER_CANCEL_REQUESTED,
  ORDER_CANCELED,
  MANUAL_REVIEW_REQUESTED;

  public String eventId(final String... ids) {
    if (ids.length == 0) {
      throw new IllegalArgumentException("Event id parts are required");
    }
    final var raw = this.name() + ":" + String.join(":", ids);
    return UUID.nameUUIDFromBytes(raw.getBytes(StandardCharsets.UTF_8)).toString();
  }
}
