package com.kasjan.common.event;

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

  public AccountCreatedEvent(
      final String accountId,
      final String externalId,
      final String username,
      final String familyName,
      final String pictureUrl,
      final String email,
      final Instant createdAt
  ) {
    this(EventType.ACCOUNT_CREATED, accountId, externalId, username, familyName, pictureUrl, email, createdAt);
  }
}
