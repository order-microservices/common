package com.kasjan.common.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Serdeable
public class AccountCreatedEvent {
  private EventType type;
  private String accountId;
  private String externalId;
  private String username;
  private String familyName;
  private String pictureUrl;
  private String email;
  private Instant createdAt;
  @JsonProperty("xRayId")
  private String xRayId;
}
