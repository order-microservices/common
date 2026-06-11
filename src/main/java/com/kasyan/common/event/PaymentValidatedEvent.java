package com.kasyan.common.event;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class PaymentValidatedEvent extends GeneralOrderEvent {
  public PaymentValidatedEvent(final String id) {
    super(EventType.PAYMENT_AUTHORIZED, id);
  }
}
