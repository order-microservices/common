package com.kasjan.common.commands;

import io.micronaut.serde.annotation.Serdeable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Serdeable
@NoArgsConstructor
public class CheckRestaurantAvailabilityCommand extends GeneralOrderCommand {
  private String restaurantId;
  private List<Dish> dishes;

  public CheckRestaurantAvailabilityCommand(
      final String orderId,
      final String accountId,
      final String restaurantId,
      final List<Dish> dishes
  ) {
    super(orderId, accountId, CommandType.CHECK_RESTAURANT_AVAILABILITY);
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
