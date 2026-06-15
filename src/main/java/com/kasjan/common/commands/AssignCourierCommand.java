package com.kasjan.common.commands;

import com.kasjan.common.model.Coordinate;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Serdeable
@NoArgsConstructor
public class AssignCourierCommand extends GeneralOrderCommand {

  private String restaurantId;
  private Coordinate coordinate;

  public AssignCourierCommand(final String orderId, final String accountId, final String restaurantId, final Coordinate coordinate) {
    super(orderId, accountId, CommandType.ASSIGN_COURIER);
    this.restaurantId = restaurantId;
    this.coordinate = coordinate;
  }
}
