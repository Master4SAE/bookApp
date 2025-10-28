package com.mybooklistApp.bookApp.run;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
public record Run(
    Integer id,
    @NotEmpty
    String title,
    LocalDateTime started0n,
    LocalDateTime completed0n,
    @Positive
    Integer miles,
    Location Location
) {
    public Run {
        if(!completed0n.isAfter(started0n)){
            throw new IllegalArgumentException("completed must be after started");
        }
    }
}
