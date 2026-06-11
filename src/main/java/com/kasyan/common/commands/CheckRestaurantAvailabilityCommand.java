package com.kasyan.common.commands;

import io.micronaut.serde.annotation.Serdeable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Serdeable
public class CheckRestaurantAvailabilityCommand extends GeneralOrderCommand {
  private final String restaurantId;
  private final List<Dish> dishes;

  public CheckRestaurantAvailabilityCommand(
      final String orderId,
      final String userId,
      final String restaurantId,
      final List<Dish> dishes
  ) {
    super(orderId, userId, CommandType.CHECK_RESTAURANT_AVAILABILITY);
    this.restaurantId = restaurantId;
    this.dishes = dishes;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @Serdeable
  public static class Dish {
    private String dishId;
    private int quantity;
  }
}
