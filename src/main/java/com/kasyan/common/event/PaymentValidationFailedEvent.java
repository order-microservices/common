package com.kasyan.common.event;

import io.micronaut.serde.annotation.Serdeable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Serdeable
public class PaymentValidationFailedEvent extends GeneralOrderEvent {
  private final String errorMessage;

  public PaymentValidationFailedEvent(final String errorMessage, final String id) {
    super(EventType.PAYMENT_VALIDATION_FAILED, id);
    this.errorMessage = errorMessage;
  }
}
