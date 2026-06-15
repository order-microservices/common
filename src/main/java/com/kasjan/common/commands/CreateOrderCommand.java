package com.kasjan.common.commands;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Serdeable
@NoArgsConstructor
public class CreateOrderCommand extends GeneralOrderCommand {
  private String restaurantId;
  private Double amount;
  private String currency;

  public CreateOrderCommand(String orderId, String accountId, String restaurantId, Double amount, String currency) {
    super(orderId, accountId, CommandType.CREATE_ORDER);
    this.restaurantId = restaurantId;
    this.amount = amount;
    this.currency = currency;
  }
}
