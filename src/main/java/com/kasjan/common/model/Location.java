package com.kasjan.common.model;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Location(double latitude, double longitude) {
}
