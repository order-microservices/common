package com.kasyan.common.commands;

import io.micronaut.serde.annotation.Serdeable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Serdeable
public class UnassingCourierCommand extends GeneralOrderCommand {

  private final String courierId;

  public UnassingCourierCommand(final String orderId, final String courierId) {
    super(orderId, null, CommandType.UNASSIGN_COURIER);
    this.courierId = courierId;
  }
}
