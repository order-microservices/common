package com.kasyan.common.event;

public class PaymentValidatedEvent extends GeneralOrderEvent {
  public PaymentValidatedEvent(final String id) {
    super(EventType.PAYMENT_AUTHORIZED, id);
  }
}
