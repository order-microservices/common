package com.kasjan.common.commands;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Serdeable
@NoArgsConstructor
public class VoidPaymentCommand extends GeneralOrderCommand {

  private double amount;

  public VoidPaymentCommand(final String orderId, final String accountId, final double amount) {
    super(orderId, accountId, CommandType.VOID_PAYMENT);
    this.amount = amount;
  }
}
