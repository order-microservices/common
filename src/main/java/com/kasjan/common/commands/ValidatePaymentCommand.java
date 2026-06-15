package com.kasjan.common.commands;

import io.micronaut.serde.annotation.Serdeable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Serdeable
@NoArgsConstructor
public class ValidatePaymentCommand extends GeneralOrderCommand {

  private Double amount;

  public ValidatePaymentCommand(final String orderId, String userId, final Double amount) {
    super(orderId, userId, CommandType.VALIDATE_PAYMENT);
    this.amount = amount;
  }
}
