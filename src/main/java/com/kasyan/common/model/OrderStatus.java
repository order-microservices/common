package com.kasyan.common.model;

import java.util.Set;

public enum OrderStatus {
  NEW,
  CANCELING,
  CANCELED,
  PAYMENT_AUTHORIZED,
  PAYMENT_AUTHORIZATION_FAILED,
  RESTAURANT_CHECKED,
  COURIER_ASSIGNED,
  COURIER_UNASSIGNED,
  COURIER_TOOK_DELIVERY,
  DELIVERED,
  MANUAL_REVIEW;

  public static final Set<OrderStatus> FINAL_STATUSES = Set.of(DELIVERED, CANCELED);

  public boolean isTerminal() {
    return FINAL_STATUSES.contains(this);
  }

  public boolean isTerminalOrManualReview() {
    return isTerminal() || this == MANUAL_REVIEW;
  }
}