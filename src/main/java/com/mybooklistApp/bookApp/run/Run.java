package com.mybooklistApp.bookApp.run;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
public record Run(
    Integer id,
    @NotEmpty
    String title,
    LocalDateTime started_on,
    LocalDateTime completed_on,
    @Positive
    Integer miles,
    Location location
) {
    public Run {
        if(!completed_on.isAfter(started_on)){
            throw new IllegalArgumentException("completed must be after started");
        }
    }
}
