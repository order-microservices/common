package com.kasjan.common.event;

import io.micronaut.serde.annotation.Serdeable;
import lombok.NoArgsConstructor;

@Serdeable
@NoArgsConstructor
public class PaymentVoidedEvent extends GeneralOrderEvent {
  public PaymentVoidedEvent(final String id) {
    super(EventType.PAYMENT_VOIDED, id);
  }
}
