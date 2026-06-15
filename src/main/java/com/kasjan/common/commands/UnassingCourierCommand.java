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
public class UnassingCourierCommand extends GeneralOrderCommand {

  private String courierId;

  public UnassingCourierCommand(final String orderId, final String courierId) {
    super(orderId, null, CommandType.UNASSIGN_COURIER);
    this.courierId = courierId;
  }
}
