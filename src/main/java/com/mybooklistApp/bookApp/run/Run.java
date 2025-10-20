package com.mybooklistApp.bookApp.run;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record Run(
    Integer id,
    String title,
    LocalDateTime started0n,
    LocalDateTime completed0n,
    Integer miles,
    Location Location
) {}
