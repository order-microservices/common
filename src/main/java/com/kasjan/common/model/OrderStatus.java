package com.kasjan.common.model;

import java.util.Set;

public enum OrderStatus {
  NEW,
  CANCELING,
  CANCELED,
  PAYMENT_AUTHORIZED,
  PAYMENT_VOIDED,
  PAYMENT_AUTHORIZATION_FAILED,
  RESTAURANT_CHECKED,
  RESTAURANT_CHECK_FAILED,
  ORDER_OFFERED_TO_COURIER,
  COURIER_ASSIGNED,
  COURIER_UNASSIGNED,
  COURIER_TOOK_DELIVERY,
  DELIVERED,
  MANUAL_REVIEW;

  public static final Set<OrderStatus> FINAL_STATUSES = Set.of(DELIVERED, CANCELED);

  public boolean isTerminal() {
    return FINAL_STATUSES.contains(this);
  }

  public boolean isCanBeCancelledSilently() {
    return this == NEW || this == PAYMENT_AUTHORIZATION_FAILED || this == PAYMENT_VOIDED;
  }

  public boolean isCanNotBeCancelled() {
    return isTerminal() || this == COURIER_TOOK_DELIVERY;
  }
}