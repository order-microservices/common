package com.kasjan.common.event;

import io.micronaut.serde.annotation.Serdeable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Serdeable
@NoArgsConstructor
public class PaymentValidationFailedEvent extends GeneralOrderEvent {
  private String errorMessage;

  public PaymentValidationFailedEvent(final String errorMessage, final String id) {
    super(EventType.PAYMENT_VALIDATION_FAILED, id);
    this.errorMessage = errorMessage;
  }
}
