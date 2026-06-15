package com.kasjan.common.commands;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Serdeable
@NoArgsConstructor
public class CancelOrderCommand extends GeneralOrderCommand {
  private String reason;

  public CancelOrderCommand(String orderId, String reason) {
    super(orderId, null, CommandType.CANCEL_ORDER);
    this.reason = reason;
  }
}