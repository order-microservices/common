package com.kasyan.common.event;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PaymentValidationFailedEvent extends GeneralOrderEvent {
  private final String errorMessage;

  public PaymentValidationFailedEvent(final String errorMessage, final String id) {
    super(EventType.PAYMENT_VALIDATION_FAILED, id);
    this.errorMessage = errorMessage;
  }
}
