package com.kasyan.common.commands;

import io.micronaut.serde.annotation.Serdeable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Serdeable
public class ValidatePaymentCommand extends GeneralOrderCommand {
  private final Double amount;

  public ValidatePaymentCommand(final String orderId, String userId, final Double amount) {
    super(orderId, userId, CommandType.VALIDATE_PAYMENT);
    this.amount = amount;
  }
}
