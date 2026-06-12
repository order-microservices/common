package com.kasyan.common.commands;

import com.kasyan.common.model.Coordinate;
import io.micronaut.serde.annotation.Serdeable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Serdeable
public class FindCourierCommand extends GeneralOrderCommand {

  private final String restaurantId;
  private final Coordinate coordinate;

  public FindCourierCommand(final String orderId, final String userId, final String restaurantId, final Coordinate coordinate) {
    super(orderId, userId, CommandType.ASSIGN_COURIER);
    this.restaurantId = restaurantId;
    this.coordinate = coordinate;
  }
}
