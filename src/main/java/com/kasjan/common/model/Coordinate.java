package com.kasjan.common.model;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

@Data
@Serdeable
public class Coordinate {
  private double latitude;
  private double longitude;
}
