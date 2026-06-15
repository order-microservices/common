package com.kasjan.common.event;

import io.micronaut.serde.annotation.Serdeable;
import lombok.NoArgsConstructor;

@Serdeable
@NoArgsConstructor
public class PaymentValidatedEvent extends GeneralOrderEvent {
  public PaymentValidatedEvent(final String id) {
    super(EventType.PAYMENT_AUTHORIZED, id);
  }
}
