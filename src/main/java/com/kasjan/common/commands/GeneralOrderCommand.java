package com.kasjan.common.commands;

import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Serdeable
public class GeneralOrderCommand {
  private String orderId;
  private String userId;
  private CommandType type;
}
