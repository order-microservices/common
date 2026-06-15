package com.kasjan.common.commands;

import io.micronaut.serde.annotation.Serdeable;
import lombok.NoArgsConstructor;

@Serdeable
@NoArgsConstructor
public class VoidPaymentCommand extends GeneralOrderCommand {

  public VoidPaymentCommand(final String orderId) {
    super(orderId, null, CommandType.VOID_PAYMENT);
  }
}
